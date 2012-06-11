<html>
<%@ page language="java" import="javazoom.upload.*,java.util.*" %>
<%@ page errorPage="ExceptionHandler.jsp" %>

<jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
  <jsp:setProperty name="upBean" property="folderstore" value="c:/uploads" />
  <jsp:setProperty name="upBean" property="parser" value="<%= MultipartFormDataRequest.CFUPARSER %>"/>
  <jsp:setProperty name="upBean" property="parsertmpdir" value="c:/temp"/>
  <jsp:setProperty name="upBean" property="overwritepolicy" value="nametimestamp" />
</jsp:useBean>

<head>
<title>Samples : Form Upload</title>
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
                if (file != null) out.println("<li>Form fields : uploadfile"+"<BR> Uploaded file : "+file.getFileName()+" ("+file.getFileSize()+" bytes)"+"<BR> Content Type : "+file.getContentType());
                // Uses the bean now to store specified by jsp:setProperty at the top.
                upBean.store(mrequest, "uploadfile");
            }
            else
            {
               out.println("<li>No uploaded files");
            }
		    if (mrequest != null)
		    {
		      out.println("<BR> mytextfield="+mrequest.getParameter("mytextfield"));
		      out.println("<BR> myselect="+mrequest.getParameter("myselect"));
		      String[] vals = mrequest.getParameterValues("multipleselect");
		      if (vals != null)
		      {
			    for (int j=0;j<vals.length;j++)
                {
			      out.println("<BR> multipleselect="+vals[j]);
			    }
		      }
		      out.println("<BR> mycheckbox="+mrequest.getParameter("mycheckbox"));
		      out.println("<BR> myradiobutton="+mrequest.getParameter("myradiobutton"));
		      out.println("<BR> mytextarea="+mrequest.getParameter("mytextarea"));
		    }
	     }
         else out.println("<BR> todo="+todo);
      }
%>
</ul>
<form method="post" action="FormUpload.jsp" name="upform" enctype="multipart/form-data">
  <table width="60%" border="0" cellspacing="1" cellpadding="1" align="center">
    <tr>
      <td align="left">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="style1">
          <tr>
            <td><b>TextField : </b></td>
            <td> <input type="text" name="mytextfield"></td>
          </tr>
          <tr>
            <td><b>List : </b></td>
            <td>
              <select name="myselect">
                <option value="item1" selected>Item 1</option>
                <option value="item2">Item 2 </option>
                <option value="item3">Item 3</option>
              </select>
              </td>
          </tr>
          <tr>
            <td><b>CheckBox : </b></td>
            <td> <input type="checkbox" name="mycheckbox" value="true">True </td>
          </tr>
          <tr>
            <td><b>Radio : </b></td>
            <td>
              <input type="radio" name="myradiobutton" value="true">
              True
              <input type="radio" name="myradiobutton" value="false">
              False </td>
          </tr>
          <tr>
            <td><b> Multiple List : </b></td>
            <td>
              <select name="multipleselect" multiple size="3">
                <option value="item10">Item 10</option>
                <option value="item11">Item 11</option>
                <option value="item12">Item 12</option>
                <option value="item13">Item 13</option>
              </select>
              </td>
          </tr>
          <tr>
            <td><b>TextArea : </b></td>
            <td> <textarea name="mytextarea" rows="3" cols="30" class="style1"></textarea></td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td align="left"><font size="-1" face="Verdana, Arial, Helvetica, sans-serif"><b>Select
        a file to upload :</b></font></td>
    </tr>
    <tr>
      <td align="left"><input type="file" name="uploadfile" size="50"></td>
    </tr>
    <tr>
      <td align="left">
        <input type="hidden" name="todo" value="upload">
        <input type="submit" name="Submit" value="Submit">
        <input type="reset" name="Reset" value="Cancel">
        </td>
    </tr>
  </table>
  <br>
  <br>
  <table width="90%" border="0" cellspacing="1" cellpadding="0" align="center">
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
              <b>action</b>=&quot;<b><font color="#FF0000">FormUpload.jsp</font></b>&quot;
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
  <p align="center"><font size="-1" face="Courier New, Courier, mono">Copyright
    &copy; <a href="http://www.javazoom.net" target="_blank">JavaZOOM</a> 1999-2006</font></p>
</form>
</body>
</html>
