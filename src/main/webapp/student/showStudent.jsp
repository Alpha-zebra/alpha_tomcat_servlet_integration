<%@ page import="jdbc.dao.StudentDao" %>
<%@ page import="jdbc.dao.StudentDaoImpl" %>
<%@ page import="jdbc.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-14
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>show student</title>
</head>
<body>
<%
//    request.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(request.getParameter("id"));
    StudentDao dao = new StudentDaoImpl();
    Student student = dao.get(id);
%>
id:<%=student.getId()%><br>
name:<%=student.getName()%><br>
gender:<%=student.getGender()%><br>
bronday:<%=student.getBornday()%><br>
</body>
</html>
