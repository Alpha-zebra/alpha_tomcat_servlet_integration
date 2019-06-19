<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-06-11
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String pwd=request.getParameter("pwd");
    String user=request.getParameter("user");
    if (pwd.equals("alpha") && user !=null){
        if ("1".equals(request.getParameter("ok"))){
           Cookie c=new Cookie("username",user);
           c.setMaxAge(60*3);
           response.addCookie(c);
        }
        session.setAttribute("alpha",user);
        response.sendRedirect("success.jsp");
    }


    else{
        request.setAttribute("error","密码不正确");
        request.setAttribute("test","test");
        request.getRequestDispatcher("login.jsp").forward(request,response);

    }
%>
