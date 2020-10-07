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
    User currentUser = (User) session.getAttribute("user");
    String editErrorMessage = (String) session.getAttribute("editError");
%>
<nav>
    <ul>
        <li><a href="index.jsp">HOME</a></li>
        <li><a href="menu">MENU</a></li>
        <li><a href="sign-in">LOGIN</a></li>
        <li><a href="register">REGISTER</a></li>
        <li><a href="account">ACCOUNT</a></li>
        <li><a href="edit">EDIT</a></li>
    </ul>
</nav>
<div align="middle">
    <h1>Welcome to your account, <%=currentUser.getLogin()%>!</h1>
    <p></p>
    <h3><%if(editErrorMessage != null){out.print(editErrorMessage);}%></h3>
    <table>
        <form action="edit" method="post">
            <tr>
                <td align="middle">Login:</td>
                <td align="middle">
                    <input align="middle" type="text" name="newLogin"
                           value="<%=currentUser.getLogin()%>"
                    />
                </td>
            </tr>
            <tr>
                <td align="middle">Password:</td>
                <td align="middle">
                    <input align="middle" type="text" name="newPassword"
                           value="<%=currentUser.getPassword()%>"
                    />
                </td>
            </tr>
            <tr>
                <td align="middle">Email:</td>
                <td align="middle">
                    <input align="middle" type="text" name="newEmail"
                           value="<%=currentUser.getEmail()%>"
                    />
                </td>
            </tr>
        <tr>
            <br>
            <td></td>
            <td align="middle">
                    <input type="submit" value="Save">
            </td>
        </tr>
        </form>
    </table>
</div>
</body>
</html>
