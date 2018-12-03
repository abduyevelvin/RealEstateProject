<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 13/04/2018
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.removeAttribute("users");
    session.invalidate();
    response.sendRedirect("login.jsp");
%>