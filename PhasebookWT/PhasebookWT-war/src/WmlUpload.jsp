<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN"
"http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="javazoom.upload.*,java.util.*" %>
<%@ page errorPage="ExceptionHandler.jsp" %>

<jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
  <jsp:setProperty name="upBean" property="folderstore" value="c:/uploads" />
</jsp:useBean>

<head>
<style type="text/css">
<!--
body {font-weight:normal; font-size:medium; font-family: sans-serif;margin: 0px}
input {margin:1px; border-style:solid; border-width:1px; padding:2px}
table,tr {border-width:0px; border-style:solid; text-align:left; padding: 0px}
td {align:right; valign:middle; border-width:0px; border-style:solid; padding: 1px}
.s {font-size:smaller;}
.blue_button {
	background-color:#DDDDFF;
	border-style:solid;
	border-width:1px;
    font-size:smaller;
}
-->
</style>
<title>Samples : WML Upload</title>
</head>
<body>
<p class="s">
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
                    if (file != null) out.println("Uploaded file : "+file.getFileName()+" ("+file.getFileSize()+" bytes)"+"<br/> Content Type : "+file.getContentType());
                    // Uses the bean now to store specified by jsp:setProperty at the top.
                    upBean.store(mrequest, "uploadfile");
                }
                else
                {
                  out.println("<br/>No uploaded files");
                }
	     }
         else out.println("<br/> todo="+todo);
      }
%>
</p>
<form method="post" action="WmlUpload.jsp" enctype="multipart/form-data">
  <table align="center">
    <tr>
      <td align="left" class="s"><b>Select a file to upload :</b></td>
    </tr>
    <tr>
      <td align="left">
        <input type="file" name="uploadfile"/>
        </td>
    </tr>
    <tr>
      <td align="left">
        <input type="hidden" name="todo" value="upload"/>
        <input type="submit" name="Submit" value="Upload" class="blue_button"/>
        <input type="reset" name="Reset" value="Cancel" class="blue_button"/>
        </td>
    </tr>
  </table>
  <br/>
  <p class="s" align="center"><a href="http://www.javazoom.net" target="_blank">JavaZOOM</a> 1999-2006</p>
</form>
</body>
</html>
