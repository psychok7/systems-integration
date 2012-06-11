<html>
<%@ page language="java" import="javazoom.upload.*,java.util.*" %>
<%@ page errorPage="ExceptionHandler.jsp" %>

<jsp:useBean id="upBean" scope="application" class="javazoom.upload.UploadBean" >
<%
  Properties props = new Properties();
  // Modify info below to fit to your database settings.
  props.put("user","scott");
  props.put("password","tiger");
  upBean.setDatabasestore("oracle.jdbc.driver.OracleDriver",
   "jdbc:oracle:thin:@MYSERVER:1521:ORCL", props);
  // If you have get a JDBC Connection from a javax.sql.DataSource
  // Then use upBean.setDatabasestore(YourConnection);
  // Also, uncomment and modify variables below if you need to map to your own database schema.
  //UploadBean.SQLUPLOADTABLE = "UPLOADS";
  //UploadBean.SQLUPLOADID = "UPLOADID";
  //UploadBean.SQLUPLOADFILENAME = "FILENAME";
  //UploadBean.SQLUPLOADFILE = "BINARYFILE";
  // Note that if you need to modify SQL request then see UploadBean
  // add-ons section to plug a custom DBStore implementation (BLOB, ...).
%>
</jsp:useBean>
<jsp:setProperty name="upBean" property="overwrite" value="true" />

<head>
<title>Samples : Database Upload</title>
<style TYPE="text/css">
<!--
.style1 {
	font-size: 12px;
	font-family: Verdana;
}
-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body bgcolor="#FFFFFF" text="#000000">
<ul class="style1">
<%
      if (MultipartFormDataRequest.isMultipartFormData(request))
      {
         // Uses MultipartFormDataRequest to parse the HTTP request.
         MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
         String todo = null;
         if (mrequest != null) todo = mrequest.getParameter("todo");
	     if ( (todo != null) && (todo.equalsIgnoreCase("upload")) )
	     {
                Hashtable files = mrequest.getFiles();
                if ( (files != null) && (!files.isEmpty()) )
                {
                    UploadFile file = (UploadFile) files.get("uploadfile");
                    if (file != null) out.println("<li>Form field : uploadfile"+"<BR> Uploaded file : "+file.getFileName()+" ("+file.getFileSize()+" bytes)"+"<BR> Content Type : "+file.getContentType());
                    // Store uploaded files in database now. Third parameter allows to pass options Map.
                    HashMap options = null;
                    // Sample advanced options.
                    //options = new HashMap();
                    //options.put("dbstore.uploadid","id."+System.currentTimeMillis());
                    //options.put("dbstore.filesize","enabled");
                    //options.put("dbstore.filetype","enabled");
                    //options.put("dbstore.customcolumn.created_date",new Date());
                    upBean.store(mrequest, "uploadfile", options);
                    // int lastid = ((DefaultDBStore)upBean.getDatabasestoreimplementation()).getLastId();
                }
                else
                {
                  out.println("<li>No uploaded files");
                }
	     }
         else out.println("<BR> todo="+todo);
      }
      Vector history = upBean.getHistory();
      int amount = 0;
      if (history != null) amount = history.size();
     %>
  <br><i>(Uploaded files : <%= amount %>)</i>
</ul>
<form method="post" action="DatabaseUpload.jsp" name="upform" enctype="multipart/form-data">
  <table width="60%" border="0" cellspacing="1" cellpadding="1" align="center" class="style1">
    <tr>
      <td align="left"><b>Select
        a file to upload :</b></td>
    </tr>
    <tr>
      <td align="left">
        <input type="file" name="uploadfile" size="50">
        </td>
    </tr>
    <tr>
      <td align="left">
		<input type="hidden" name="todo" value="upload">
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
              HTML tags used in this form :</font></b></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;&lt;<b>form</b>
              <b>method</b>=&quot;<b><font color="#FF0000">post</font></b>&quot;
              <b>action</b>=&quot;<b><font color="#FF0000">DatabaseUpload.jsp</font></b>&quot;
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
