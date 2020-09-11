<%--
  Created by IntelliJ IDEA.
  User: midicq
  Date: 9/11/2020
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="index.html">HOME</a></li>
        <li><a href="menu">MENU</a></li>
        <li><a href="sign-in">SIGN IN</a></li>
        <li><a href="register">REGISTER</a></li>
    </ul>
</nav>
<div align="middle">
    <h1>Registration</h1>
    <p>To create an account enter login(nickname), password and email. Then click on Register button.</p>
    <form action="register" method="post">
        <table>
            <tr>
                <td align="right">Login:</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td align="right">Email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td></td>
                <td><br><input type="submit" value="Register"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
