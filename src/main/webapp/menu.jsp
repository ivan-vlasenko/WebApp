<%@ page import="model.DishDao" %>
<%@ page import="entity.Dish" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: midicq
  Date: 9/10/2020
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Menu</title>
</head>
<body>
<div align="middle">
    <h1>Menu Page</h1>
</div>
<div align="right" >
    <form action="search">
        <h3>Search</h3>
        <input type="search" value="enter dish name" size="35">
    </form>
</div>
    <div align="middle">
        <h2>Menu</h2>
    </div>
<div class="rightContainer">
    <h3>
        <%
            DishDao dishDao = new DishDao();
            dishDao.driverRegister();
            dishDao.dataBase();
            List<Dish> dishList = dishDao.getDishes();

            for (Dish dish : dishList) {
                out.println(dish.toString());
            }
        %>
    </h3>
</div>
</body>
</html>
