<%@ page import="model.AllDishDao" %>
<%@ page import="entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AllDishDao allDishes = new AllDishDao();
    allDishes.driverRegister();
    allDishes.dataBase();
    List<Dish> dishList = allDishes.getDishes();
%>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="menu">Menu</a></li>
    </ul>
</nav>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-10 pb-5 text-center">
            <h1 class="quicksand-font header text-uppercase">Menu</h1>
            <hr>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-10 pb-5 text-center">
            <h4 class="text-center quicksand-font text-uppercase">Appetizer</h4>
            <p class="text-uppercase">Oysters and Pearls</p>
            <p class="text-uppercase">Sabayon of pearl tapioca with island greek oysters</p>
            <p class="text-uppercase">White Sturgeon Caviar</p>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-10 pb-5 text-center">
            <h4 class="text-center quicksand-font text-uppercase">First Course</h4>
            <p class="text-uppercase">Chantenay Carrot Tofu</p>
            <p class="text-uppercase">Hawaiian Heart of Peach Pea and Lime</p>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-10 pb-5 text-center">
            <h4 class="text-center quicksand-font text-uppercase">Main Course</h4>
            <p class="text-uppercase">Slow Cook Fillet Of Pacific Yellowtail</p>
            <p class="text-uppercase">Compress Cucumbers, Avocado Mousse, And Garden Celery</p>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-10 pb-5 text-center">
            <h4 class="text-center quicksand-font text-uppercase">Dessert</h4>
            <p class="text-uppercase">Chocolate Soufflet</p>
            <p class="text-uppercase">Strawberry and Vanilla Sorbet</p>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-10 pb-5 text-center">
            <h4 class="text-center quicksand-font text-uppercase">Wine</h4>
            <p class="text-uppercase">White: Reisling Chardonnay</p>
            <p class="text-uppercase">Red: Mary Rivers, Pinot Noir, Sonoma Coast</p>
        </div>
    </div>
</div>
</body>
</html>
