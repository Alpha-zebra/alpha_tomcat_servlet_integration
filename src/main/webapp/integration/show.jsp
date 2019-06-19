<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-19
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp" %>
<head>
    <title>show</title>
</head>
<body>



    Id:<input type="number" name="id" value="${student.id}" disabled><br/>
    Name:<input type="text" name="name" value="${student.name}" disabled><br/>
    Gender:<input type="radio" name="gender" checked value="男" disabled>男
    <input type="radio" name="gender"<c:if test="${student.gender eq '女'}">checked</c:if> value="女" disabled>女<br/>
    <fmt:formatDate value="${student.bornday}" var="birthday" pattern="yyyy-MM-dd'T'HH:mm"></fmt:formatDate>
    Birthday:<input type="datetime-local" name="bornday" value="${birthday}" disabled>


</body>
</html>
