<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-11
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<%
    String username= (String) session.getAttribute("alpha");
    if (username==null){
        Cookie[] cs=request.getCookies();
        if (cs!=null){
            for (Cookie c:cs){
                if ("username".equals(c.getName())){
                    username=c.getValue();
                    session.setAttribute("alpha",username);
                }
            }
        }
    }
    if (username==null){
        response.sendRedirect("login.jsp");
    }
%>
<%=session.getAttribute("alpha")%>
Welcome to service!
</body>
</html>
