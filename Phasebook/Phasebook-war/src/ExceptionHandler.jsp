<%@ page isErrorPage="true" import="java.io.*" %>
<% response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, exception.toString()); %>
<% response.setHeader("customerror",exception.toString()); %>
<html>
<head>
  <title>Exceptional Even Occurred!</title>
</head>
<body>
<%-- Exception Handler --%>
<font size="-1" face="Verdana, Arial, Helvetica, sans-serif" color="red">
<b><%= exception.toString() %></b><br/>
</font>
<%
if (exception.toString().indexOf("OutOfMemoryError") > 0)
{
   out.println("<br/>Switch to CFUPARSER, by adding the following to your JSP :<br/>");
   out.println("&lt;jsp:setProperty name=\"upBean\" property=\"parser\" value=\"&lt;%= MultipartFormDataRequest.CFUPARSER %&gt;\"/&gt;<br/>");
   out.println("&lt;jsp:setProperty name=\"upBean\" property=\"parsertmpdir\" value=\"c:/temp\"/&gt;<br/>");
}
else if (exception.toString().indexOf("JasperException") > 0)
{
   out.println("<br/>Check UploadBean properties in your JSP.<br/> For folder store check : ");
   out.println(" &lt;jsp:setProperty name=\"upBean\" property=\"folderstore\" value=\"c:/uploads\" /&gt;<br/>");
}
out.println("<!--");
StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);
exception.printStackTrace(pw);
out.print(sw);
sw.close();
pw.close();
out.println("-->");
%>
</body>
</html>
