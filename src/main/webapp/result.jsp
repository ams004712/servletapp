<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    User Form
</h1>
<%
String userName= (String) request.getAttribute("userName");

out.println("<br>We have entered user name:<br><br>");


out.println(userName+"<br>");


String employee= (String) request.getAttribute("employee");

out.println("<br>employee:<br><br>");


out.println(employee+"<br>");



%>
</body>
</html>
