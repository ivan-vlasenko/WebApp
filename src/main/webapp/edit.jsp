<%@ page import="entity.user.User" %><%--
  Created by IntelliJ IDEA.
  User: midicq
  Date: 9/11/2020
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String log = (String) session.getAttribute("log");
    String pass = (String) session.getAttribute("pass");
    String email = (String) session.getAttribute("email");

    out.println(log);
    out.println(pass);
    out.println(email);
%>
<nav>
    <ul>
        <li><a href="index.jsp">HOME</a></li>
        <li><a href="menu">MENU</a></li>
        <li><a href="sign-in">SIGN IN</a></li>
        <li><a href="register">REGISTER</a></li>
        <li><a href="account">ACCOUNT</a></li>
    </ul>
</nav>
<div align="middle">
    <h1>Welcome to your account, <%=log%>!</h1>
    <p></p>
    <table>
        <form action="edit" method="post">
            <tr>
                <td align="middle">Login:</td>
                <td align="middle">
                    <input align="middle" type="text" name="login"
                           value="<%=log%>"
                    />
                </td>
            </tr>
            <tr>
                <td align="middle">Password:</td>
                <td align="middle">
                    <input align="middle" type="text" name="password"
                           value="<%=pass%>"
                    />
                </td>
            </tr>
            <tr>
                <td align="middle">Email:</td>
                <td align="middle">
                    <input align="middle" type="text" name="email"
                           value="<%=email%>"
                    />
                </td>
            </tr>
        <tr>
            <br>
            <td></td>
            <td align="middle">
                    <input type="submit" value="Save">
            </td>
        </form>
            <td align="middle">
                <form action="delete" method="get">
                    <input type="submit" value="Delete Account">
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
