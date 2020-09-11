<%@ page import="model.AllDishDao" %>
<%@ page import="entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page import="model.AllDishDao" %><%--
  Created by IntelliJ IDEA.
  User: midicq
  Date: 9/10/2020
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AllDishDao allDishDao = new AllDishDao();
    allDishDao.driverRegister();
    allDishDao.dataBase();
    List<Dish> dishList = allDishDao.getDishes();
%>

<html>
<head>
    <title>Menu</title>
</head>
<body>
<div align="middle">
    <h1>Menu Page</h1>
</div>
<div align="right" >
    <form action=search method="post">
        Please enter dish name:<br>
        Dish: <input type="text" name="dish"><br>
        <input type="submit">
    </form>
</div>
    <div align="middle">
        <h2>Menu</h2>
    </div>
<div class="rightContainer">
    <table align="middle">
        <tr>
            <td><%= dishList.get(0).getName().toUpperCase() %></td><br>
            <td><%= dishList.get(0).getCuisine() %></td><br>
            <td><%= dishList.get(0).getCategory() %></td><br>
            <td></td>
            <td><%= dishList.get(1).getName().toUpperCase() %></td>
            <td><%= dishList.get(1).getCuisine() %></td>
            <td><%= dishList.get(1).getCategory() %></td>
            <td></td>
            <td><%= dishList.get(2).getName().toUpperCase() %></td>
            <td><%= dishList.get(2).getCuisine() %></td>
            <td><%= dishList.get(2).getCategory() %></td>
            <td></td>
            <td><%= dishList.get(3).getName().toUpperCase() %></td>
            <td><%= dishList.get(3).getCuisine() %></td>
            <td><%= dishList.get(3).getCategory() %></td>
            <td></td>
        </tr>

    </table>
</div>
</body>
</html>
