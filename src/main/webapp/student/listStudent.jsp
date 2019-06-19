<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jdbc.dao.StudentDao" %>
<%@ page import="jdbc.dao.StudentDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="jdbc.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-14
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>list Student</title>
</head>
<body>
<%
//    String sql="select * from student";
//    StudentDao dao=new StudentDaoImpl();
//    List<Student> students=dao.list();
//    request.setAttribute("students",students);

%>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>gender</td>
        <td>bornday</td>
        <td>operate</td>
    </tr>
    <c:forEach items="${students}" var="student" varStatus="st">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.bornday}</td>
            <td>
                <a href="doEditStudent.jsp?id=${student.id}">edit</a>
                <a href="doEditStudent.jsp?id=${student.id}">edit</a>
                <a href="deleteStudent.do?id=${student.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
