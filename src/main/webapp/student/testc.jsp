<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-14
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
    %>
</head>
<body>
<%=name%>
${name}
</body>
</html>
