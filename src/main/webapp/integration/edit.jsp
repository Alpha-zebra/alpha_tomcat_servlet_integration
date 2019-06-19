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
    <title>${title} 学员页</title>
</head>
<body>
${title} 学员表单
<c:set var="btn" value="保存" scope="page"></c:set>
<form action="update" method="post">
    <c:if test="${not empty param['id']}">
        Id:<input type="number" name="id" value="${student.id}" disabled><br/>
        <c:set var="btn" value="修改" scope="page"></c:set>
    </c:if>
    Name:<input type="text" name="name" value="${student.name}"><br/>
    Gender:<input type="radio" name="gender" checked value="男">男
    <input type="radio" name="gender"<c:if test="${student.gender eq '女'}">checked</c:if> value="女" >女<br/>
<fmt:formatDate value="${student.bornday}" var="birthday" pattern="yyyy-MM-dd'T'HH:mm"></fmt:formatDate>
    Birthday:<input type="datetime-local" name="bornday" value="${birthday}"><br/>
    <input type="submit" value="${btn}">
</form>
</body>
</html>
