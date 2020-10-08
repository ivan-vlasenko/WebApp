<%--
  Created by IntelliJ IDEA.
  User: midicq
  Date: 9/11/2020
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String existErrorMessage = (String) session.getAttribute("existError");
    String emptyErrorMessage = (String) session.getAttribute("emptyError");
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
    <h1>Registration</h1>
    <p>To create an account enter login(nickname), password and email. Then click on Register button.</p>
    <form action="register" method="post">
        <table>
            <tr>
                <td align="right">Login:</td>
                <td><label>
                    <input type="text" name="login">
                </label></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td><label>
                    <input type="password" name="password">
                </label></td>
            </tr>
            <tr>
                <td align="right">Email:</td>
                <td><label>
                    <input type="text" name="email">
                </label></td>
            </tr>
            <tr>
                <td><br></td>
                <td align="right">
                    <%
                        if (existErrorMessage != null) out.print(existErrorMessage);
                        if (emptyErrorMessage != null) out.print(emptyErrorMessage);
                    %>
                </td>
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
