<html>
<%@ page language="java" import="javazoom.upload.*,java.util.*" %>
<%@ page errorPage="ExceptionHandler.jsp" %>

<jsp:useBean id="upBean" scope="session" class="javazoom.upload.UploadBean" >
  <jsp:setProperty name="upBean" property="parser" value="<%= MultipartFormDataRequest.CFUPARSER %>" />
  <jsp:setProperty name="upBean" property="parsertmpdir" value="c:/temp"/>
  <jsp:setProperty name="upBean" property="maxfiles" value="10" />
  <jsp:setProperty name="upBean" property="overwrite" value="true" />
  <jsp:setProperty name="upBean" property="filesizelimit" value="<%= 1024*1024 %>" />
  <jsp:setProperty name="upBean" property="blacklist" value="*.zip,*.rar,setup.exe" />
  <jsp:setProperty name="upBean" property="zipfilestore" value="c:/uploads.zip" />
</jsp:useBean>

<head>
<title>Samples : Multiple Uploads</title>
<style TYPE="text/css">
<!--
.style1 {
	font-size: 12px;
	font-family: Verdana;
}
-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script language="Javascript"><!--
  function doUpload()
  {
    document.upload.todo.value="upload";
	document.upload.submit();
  }
  function doClean()
  {
    document.upload.todo.value="cleanstore";
	document.upload.submit();
  }
  //--></script>
</head>
<body bgcolor="#FFFFFF" text="#000000" class="style1">
<%
      if (MultipartFormDataRequest.isMultipartFormData(request))
      {
         MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
         String todo = null;
         if (mrequest != null) todo = mrequest.getParameter("todo");
	     if ( (todo != null) && (todo.equalsIgnoreCase("upload")) )
	     {
                // Uses the bean now to store specified by jsp:setProperty at the top.
                upBean.store(mrequest);
                // Displays info about uploaded files for this session.
                %>
                <b>Upload history : </b>
                <ul><font size="-2" face="Verdana, Arial, Helvetica, sans-serif">
                <%
                Vector history = upBean.getHistory();
                for (int i=0;i<history.size();i++)
                {
                    UploadParameters up = (UploadParameters) history.elementAt(i);
                    out.println("<li>Uploaded file : "+up.getFilename()+" ("+up.getFilesize()+" bytes)"+"<BR> Content Type : "+up.getContenttype());
                    out.println("<BR>StoreModel : "+up.getStoremodelname()+" ("+up.getStoreinfo()+")");
                }
                %>
                </font></ul>
                <%
	     }
	     else if ( (todo != null) && (todo.equalsIgnoreCase("cleanstore")) )
	     {
            upBean.resetStore();
            out.println("<BR>Store cleaned");
         }
         else out.println("<BR> todo="+todo);
      }
%>
<form method="post" action="MultipleUploads.jsp" name="upload" enctype="multipart/form-data">
  <table width="70%" border="0" cellspacing="1" cellpadding="1" align="center" class="style1">
    <tr>
      <td align="left"><b>Select files to upload :</b></td>
    </tr>
    <tr>
      <td align="left">Filesize limit allowed
        : <jsp:getProperty name="upBean" property="filesizelimit"/> (bytes), Maximum uploaded files allowed :
        <jsp:getProperty name="upBean" property="maxfiles"/>, not in
        <jsp:getProperty name="upBean" property="blacklist"/> and overwrite =
        <jsp:getProperty name="upBean" property="overwrite"/>
        </td>
    </tr>
    <tr>
      <td align="left"><input type="file" name="uploadfile1" size="50"></td>
    </tr>
    <tr>
      <td align="left"><input type="file" name="uploadfile2" size="50"></td>
    </tr>
    <tr>
      <td align="left"><input type="file" name="uploadfile3" size="50"></td>
    </tr>
    <tr>
      <td align="left">
        <input type="hidden" name="todo">
        <input type="button" name="Submit" value="Upload" onClick="doUpload()">
        <input type="button" name="Clean" value="Reset Store" onClick="doClean()">
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
              HTML tags used in this form :</font></b></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;&lt;<b>form</b>
              <b>method</b>=&quot;<b><font color="#FF0000">post</font></b>&quot;
              <b>action</b>=&quot;<b><font color="#FF0000">MultipleUploads.jsp</font></b>&quot;
              name=&quot;upload&quot; <b>enctype</b>=&quot;<b><font color="#FF0000">multipart/form-data</font></b>&quot;&gt;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;&lt;<b>input</b>
              <b>type</b>=&quot;<b><font color="#FF0000">file</font></b>&quot;
              <b>name</b>=&quot;<font color="#FF0000"><b>uploadfile1</b></font>&quot;
              size=&quot;50&quot;&gt;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;&lt;<b>input</b>
              <b>type</b>=&quot;<b><font color="#FF0000">file</font></b>&quot;
              <b>name</b>=&quot;<font color="#FF0000"><b>uploadfile2</b></font>&quot;
              size=&quot;50&quot;&gt;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;&lt;<b>input</b>
              <b>type</b>=&quot;<b><font color="#FF0000">file</font></b>&quot;
              <b>name</b>=&quot;<font color="#FF0000"><b>uploadfile3</b></font>&quot;
              size=&quot;50&quot;&gt;</td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <p align="center">If you need to upload files and folders (with subfolders) 
    then you could use <br>
    <b>jClientUpload</b> Applet with UploadBean script. It supports drag&amp;drop 
    and <br>
    copy/pastefeatures, it also includes a progress bar. <a href="http://www.javazoom.net/applets/jclientupload/jclientupload.html" target="_blank">Learn 
    more ...</a></p>
  <p>&nbsp;</p>
  <p align="center"><font size="-1" face="Courier New, Courier, mono">Copyright
    &copy; <a href="http://www.javazoom.net" target="_blank">JavaZOOM</a> 1999-2006</font></p>
  </form>
</body>
</html>
