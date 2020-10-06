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
        <h1>Welcome to your account, <%=currentUser.getLogin()%>!</h1>
        <p></p>
            <table>
                <form action="account" method="post">
                <tr>
                    <td align="middle">Login:</td>
                    <td align="middle"><%=currentUser.getLogin()%></td>
                </tr>
                <tr>
                    <td align="middle">Password:</td>
                    <td align="middle"><%=currentUser.getPassword()%></td>
                </tr>
                <tr>
                    <td align="middle">Email:</td>
                    <td align="middle"><%=currentUser.getEmail()%></td>
                </tr>
                    <tr>
                        <td></td>
                        <td align="middle"><a href="/edit?login=<%out.print(currentUser.getLogin());%>
                                                    &password=<%out.print(currentUser.getPassword());%>
                                                    &email=<%out.print(currentUser.getEmail());%>">Edit</a></td>
                    </tr>
                </form>
                <tr>
                    <br>
                    <td></td>
                    <td align="middle">
                        <form action="logout" method="get">
                            <input type="submit" value="Logout">
                        </form>
                    </td>
                    <br>
                    <td></td>
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
