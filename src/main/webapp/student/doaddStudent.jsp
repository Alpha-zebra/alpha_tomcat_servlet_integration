<%@ page import="jdbc.pojo.Student" %>
<%@ page import="jdbc.commons.DateUtils" %>
<%@ page import="jdbc.dao.StudentDao" %>
<%@ page import="jdbc.dao.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-14
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String bornday = request.getParameter("bornday");
    Student student = new Student(name, gender, DateUtils.strConvertDate(bornday, "yyyy-MM-dd'T'HH:mm"));

    StudentDao dao = new StudentDaoImpl();
    dao.save(student);

    response.sendRedirect("showStudent.jsp?id=" + student.getId());
%>