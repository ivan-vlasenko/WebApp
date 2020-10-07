<%@ page import="entity.user.User" %><%--
  Created by IntelliJ IDEA.
  User: midicq
  Date: 9/11/2020
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign-in</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    User currentUser = (User) session.getAttribute("user");

    String emptyErrorMessage = (String) session.getAttribute("empty");
    String invalidErrorMessage = (String) session.getAttribute("invalid");
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
    <h1>Sign-in</h1>
    <p>Please enter login(nickname) and password.
        Then click on Sign-in button.</p>
    <form action="sign-in" method="post">
        <table>
            <tr>
                <td align="right">Login:</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td align="right">Email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td><br></td>
                <td align="right">
                    <%
                    if (emptyErrorMessage != null) out.print(emptyErrorMessage);
                    if (invalidErrorMessage != null) out.print(invalidErrorMessage);
                    %>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><br><input type="submit" value="Sign-in"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>