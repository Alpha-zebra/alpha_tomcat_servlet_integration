<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-11
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="check.jsp" method="post">
    UserName:<input type="text" name="user" value=""><br>
    Password:<input type="password" name="pwd" value=""><br>
    <input type="checkbox" name="ok" value="1">记住密码?<br>
    <input type="submit" value="submit"><br>
</form>
<%
    String err= (String) request.getAttribute("error");
%>
<%=err%>
EL:
${error}
${user}
${test}
</body>
</html>
