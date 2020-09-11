<%@ page import="model.AllDishDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AllDishDao allDishes = new AllDishDao();
    allDishes.driverRegister();
    allDishes.dataBase();
    List<Dish> dishList = allDishes.getDishes();

    List<Appetizer> appetizers = new ArrayList<>();
    List<Soup> soupList = new ArrayList<>();
    List<MainDish> mains = new ArrayList<>();
    List<Dessert> desserts = new ArrayList<>();
    List<Drink> drinks = new ArrayList<>();
    List<AlcoholDrink> alcoholDrinks = new ArrayList<>();

    for (Dish dish : dishList) {
        if (dish instanceof Appetizer) {
            appetizers.add((Appetizer) dish);
        } else if (dish instanceof Soup) {
            soupList.add((Soup) dish);
        } else if (dish instanceof MainDish) {
            mains.add((MainDish) dish);
        } else if (dish instanceof Dessert) {
            desserts.add((Dessert) dish);
        } else if (dish instanceof Drink) {
            drinks.add((Drink) dish);
        } else if (dish instanceof AlcoholDrink) {
            alcoholDrinks.add((AlcoholDrink) dish);
        }

    }
%>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="index.html">HOME</a></li>
        <li><a href="menu">MENU</a></li>
        <li><a href=""></a></li>
    </ul>
</nav>
<div class="container">
    <div align="middle">
        <div align="middle">
            <h1>MENU</h1>
            <hr>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>APPETIZER</h4>
            <br>
            <% for (Appetizer appetizer : appetizers) {
                out.print("<p>" + appetizer.getName().toUpperCase() + "</p>");
                out.print("<p>" + appetizer.getCuisine().toLowerCase() + " cuisine" + "</p>");
            } %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>FIRST COURSE</h4>
            <br>
            <% for (Soup soup : soupList) {
                out.print("<p>" + soup.getName().toUpperCase() + "</p>");
                out.print("<p>" + soup.getCuisine().toLowerCase() + " cuisine" + "</p>");
            } %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>MAIN COURSE</h4>
            <br>
            <% for (MainDish mainDish : mains) {
                out.print("<p>" + mainDish.getName().toUpperCase() + "</p>");
                out.print("<p>" + mainDish.getCuisine().toLowerCase() + " cuisine" + "</p>");
            } %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>DESSERT</h4>
            <br>
            <% for (Dessert dessert : desserts) {
                out.print("<p>" + dessert.getName().toUpperCase() + "</p>");
                out.print("<p>" + dessert.getCuisine().toLowerCase() + " cuisine" + "</p>");
            } %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>DRINKS</h4>
            <br>
            <% for (Drink drink : drinks) {
                out.print("<p>" + drink.getName().toUpperCase() + "</p>");
                out.print("<p>" + drink.getCuisine().toLowerCase() + " cuisine" + "</p>");
            } %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>ALCOHOL DRINKS</h4>
            <br>
            <% for (AlcoholDrink alcoholDrink : alcoholDrinks) {
                out.print("<p>" + alcoholDrink.getName().toUpperCase() + "</p>");
                out.print("<p>" + alcoholDrink.getCuisine().toLowerCase() + " cuisine" + "</p>");
            } %>
            <br>
        </div>
    </div>
</div>
</body>
</html>
