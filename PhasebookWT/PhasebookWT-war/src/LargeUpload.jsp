<%@ page language="java" import="javazoom.upload.*,java.util.*,java.io.*" %>
<%@ page errorPage="ExceptionHandler.jsp" %>

<% String directory = "c:/uploads"; %>
<% String tmpdirectory = "c:/uploads/tmp"; %>
<% boolean createsubfolders = true; %>
<% boolean allowresume = true; %>
<% boolean allowoverwrite = true; %>
<% String encoding = "ISO-8859-1"; %>
<% boolean keepalive = false; %>

<jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
  <jsp:setProperty name="upBean" property="folderstore" value="<%= directory %>" />
  <jsp:setProperty name="upBean" property="parser" value="<%= MultipartFormDataRequest.CFUPARSER %>"/>
  <jsp:setProperty name="upBean" property="parsertmpdir" value="<%= tmpdirectory %>"/>
  <jsp:setProperty name="upBean" property="filesizelimit" value="8589934592"/>
  <jsp:setProperty name="upBean" property="overwrite" value="<%= allowoverwrite %>"/>
  <jsp:setProperty name="upBean" property="dump" value="true"/>
</jsp:useBean>

<%
  //request.setCharacterEncoding(encoding);
  //response.setContentType("text/html; charset="+encoding);
  String method = request.getMethod();
  // Head processing to support resume and overwrite features.
  if (method.equalsIgnoreCase("head"))
  {
    String filename = request.getHeader("relativefilename");
    if (filename == null) filename = request.getHeader("filename");
    if (filename!=null)
    {
    	if (keepalive == false) response.setHeader("Connection","close");
    	String account = request.getHeader("account");
 	if (account == null) account="";
    	else if (!account.startsWith("/")) account = "/"+account;
    	File fhead = new File(directory+account+"/"+filename);
    	if (fhead.exists())
    	{
    	   response.setHeader("size", String.valueOf(fhead.length()));
    	   String checksum = request.getHeader("checksum");
    	   if ((checksum != null) && (checksum.equalsIgnoreCase("crc")))
    	   {
		long crc = upBean.computeCRC32(fhead,-1);
		if (crc != -1) response.setHeader("checksum", String.valueOf(crc));
    	   }
    	   else if ((checksum != null) && (checksum.equalsIgnoreCase("md5")))
    	   {
		String md5 = upBean.hexDump(upBean.computeMD5(fhead,-1)).toLowerCase();
		if ((md5 != null) && (!md5.equals(""))) response.setHeader("checksum", md5);
    	   }
    	}
    	else response.sendError(HttpServletResponse.SC_NOT_FOUND);
       return;
    }
  }
%>
<html>
<head>
<title>Samples : Large Upload + jClientUpload Applet support</title>
<style TYPE="text/css">
<!--
.style1 {
	font-size: 12px;
	font-family: Verdana;
}
-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=<%= encoding %>">
</head>
<body>
<ul class="style1">
<%
      if (MultipartFormDataRequest.isMultipartFormData(request))
      {
         // Parse multipart HTTP POST request.
         MultipartFormDataRequest mrequest = null;
         try
         {
         	mrequest = new MultipartFormDataRequest(request,null,-1,MultipartFormDataRequest.CFUPARSER,encoding,allowresume);
         } catch (Exception e)
	   {
	       // Cancel current upload (e.g. Stop transfer)
               // Only if allowresume = false
	   }
         String todo = null;
         if (mrequest != null) todo = mrequest.getParameter("todo");
         if ( (todo != null) && (todo.equalsIgnoreCase("upload")) )
         {
    	   String account = mrequest.getParameter("account");
    	   if (account == null) account="";
    	   else if (!account.startsWith("/")) account = "/"+account;
           upBean.setFolderstore(directory+account);
           Hashtable files = mrequest.getFiles();
           if ( (files != null) && (!files.isEmpty()) )
           {
             UploadFile file = (UploadFile) files.get("uploadfile");
             if (file != null) out.println("<li>Form field : uploadfile"+"<BR> Uploaded file : "+file.getFileName()+" ("+file.getFileSize()+" bytes)"+"<BR> Content Type : "+file.getContentType());
             // Folders and subfolders creation support.
             String relative = mrequest.getParameter("relativefilename");
             if ((createsubfolders == true) && (relative != null))
             {
               int inda=relative.length();
               int indb=file.getFileName().length();
               if (inda > indb)
               {
                 String subfolder = relative.substring(0,(inda-indb)-1);
                 subfolder = subfolder.replace('\\','/').replace('/',java.io.File.separatorChar);
                 upBean.setFolderstore(directory+account+java.io.File.separator+subfolder);
               }
             }
             if (keepalive == false) response.setHeader("Connection","close");
             // Chunks recomposion support.
             String chunkidStr = mrequest.getParameter("chunkid");
             String chunkamountStr = mrequest.getParameter("chunkamount");
             String chunkbaseStr = mrequest.getParameter("chunkbase");
             if ((chunkidStr != null) && (chunkamountStr != null) && (chunkbaseStr != null))
             {
               // Always overwrite chunks.
               upBean.setOverwrite(true);
               upBean.store(mrequest, "uploadfile");
               upBean.setOverwrite(allowoverwrite);
               int chunkid = Integer.parseInt(chunkidStr);
               int chunkamount = Integer.parseInt(chunkamountStr);
               if (chunkid == chunkamount)
               {
                 // recompose file.
                 String fname = upBean.getFolderstore()+java.io.File.separator+chunkbaseStr;
                 File fread = new File(fname);
                 if (fread.canRead() && (upBean.getOverwrite()==false)) fname = upBean.loadOverwriteFilter().process(fname);
                 FileOutputStream fout = new FileOutputStream(fname);
                 byte[] buffer = new byte[4096];
                 for (int c=1;c<=chunkamount;c++)
                 {
                   File filein = new File(upBean.getFolderstore()+java.io.File.separator+chunkbaseStr+"."+c);
                   FileInputStream fin = new FileInputStream(filein);
                   int read = -1;
                   while ((read = fin.read(buffer)) > 0) fout.write(buffer,0,read);
                   fin.close();
                   filein.delete();
                 }
                 fout.close();
               }
             }
             else upBean.store(mrequest, "uploadfile");
             upBean.setFolderstore(directory+account);
           }
           else
           {
             String emptydirectory = mrequest.getParameter("emptydirectory");
             if ((emptydirectory != null) && (!emptydirectory.equals("")))
             {
               File dir = new File(directory+account+"/"+emptydirectory);
               dir.mkdirs();
             }
             out.println("<li>No uploaded files");
           }
         }
         else out.println("<BR> todo="+todo);
      }
%>
</ul>
<form method="post" action="LargeUpload.jsp" name="upform" enctype="multipart/form-data">
  <table width="60%" border="0" cellspacing="1" cellpadding="1" align="center" class="style1">
    <tr>
      <td align="left"><b>Select a file to upload :</b></td>
    </tr>
    <tr>
      <td align="left">
        <input type="hidden" name="todo" value="upload">
          <input type="file" name="uploadfile" size="50">
      </td>
    </tr>
    <tr>
      <td align="left">
        <input type="submit" name="Submit" value="Upload">
        <input type="reset" name="Reset" value="Cancel">
        </td>
    </tr>
  </table>
  <br>
  <br>
  <table border="0" cellspacing="1" cellpadding="0" align="center">
    <tr>
      <td bgcolor="#666666">
        <table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" class="style1">
          <tr>
            <td bgcolor="#FFFFFF"><b><font color="#0000FF">&nbsp;
              HTML tags used in this form : </font></b></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;&lt;<b>form</b>
              <b>method</b>=&quot;<b><font color="#FF0000">post</font></b>&quot;
              <b>action</b>=&quot;<b><font color="#FF0000">LargeUpload.jsp</font></b>&quot;
              name=&quot;upload&quot; <b>enctype</b>=&quot;<b><font color="#FF0000">multipart/form-data</font></b>&quot;&gt;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;&lt;<b>input</b>
              <b>type</b>=&quot;<b><font color="#FF0000">file</font></b>&quot;
              <b>name</b>=&quot;<font color="#FF0000"><b>uploadfile</b></font>&quot;
              size=&quot;50&quot;&gt;</td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p align="center">&nbsp;</p>
  <p align="center">&nbsp;</p>
  <p align="center"><font size="-1" face="Courier New, Courier, mono">Copyright
    &copy; <a href="http://www.javazoom.net" target="_blank">JavaZOOM</a> 1999-2006</font></p>
</form>
</body>
</html>
