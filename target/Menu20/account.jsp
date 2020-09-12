<%@ page import="entity.User" %><%--
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
        <h1>Welcome, <%=log%>!</h1>
        <p></p>
        <form action="account" method="post">
            <table>
                <tr>
                    <td align="middle">Login:</td>
                    <td align="middle" contenteditable="true"><%=log%></td>
                    <td align="middle"><input type="submit" value="Change" formmethod="post"></td>
                </tr>
                <tr>
                    <td align="middle">Password:</td>
                    <td align="middle" contenteditable="true"><%=pass%></td>
                    <td align="middle"><input type="submit" value="Change" formmethod="post"></td>
                </tr>
                <tr>
                    <td align="middle">Email:</td>
                    <td align="middle" contenteditable="true"><%=email%></td>
                    <td align="middle"><input type="submit" value="Change" formmethod="post"></td>
                </tr>
                <%--<tr>
                    <td></td>
                    <td><br><input type="submit" value="Change field"></td>
                </tr>--%>
            </table>
        </form>
    </div>
</body>
</html>
