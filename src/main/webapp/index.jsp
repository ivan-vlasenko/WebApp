<%--
  Created by IntelliJ IDEA.
  User: midicq
  Date: 9/12/2020
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Restaurant</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    User currentUser = (User) session.getAttribute("user");
%>
<nav>
    <ul>
        <li><a href="index.jsp">HOME</a></li>
        <li><a href="menu">MENU</a></li>
        <li><a href="sign-in">LOGIN</a></li>
        <li><a href="register">REGISTER</a></li>
        <li><a href="account">ACCOUNT</a></li>
    </ul>
</nav>
<div align="middle">
    <h1>
        Welcome to Restaurant<%if (currentUser != null)
        {out.println(", "+currentUser.getLogin()+"!");}
        else{out.println("!");};%>
    </h1>
</div>
</body>
</html>

