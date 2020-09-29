<%@ page import="model.MenuDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.*" %>
<%@ page import="entity.drinks.AlcoholDrink" %>
<%@ page import="entity.drinks.NonAlcoholDrink" %>
<%@ page import="entity.dishes.*" %>
<%@ page import="entity.drinks.NonAlcoholDrink" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MenuDao menuDao = new MenuDao();
    List<Dish> menu = menuDao.selectAllMenu();

    List<Appetizer> appetizers = new ArrayList<>();
    List<Soup> soupList = new ArrayList<>();
    List<MainDish> mains = new ArrayList<>();
    List<Dessert> desserts = new ArrayList<>();
    List<NonAlcoholDrink> nonAlcoholDrinks = new ArrayList<>();
    List<AlcoholDrink> alcoholDrinks = new ArrayList<>();

    for (Dish dish : menu) {
        if (dish instanceof Appetizer) {
            appetizers.add((Appetizer) dish);
        } else if (dish instanceof Soup) {
            soupList.add((Soup) dish);
        } else if (dish instanceof MainDish) {
            mains.add((MainDish) dish);
        } else if (dish instanceof Dessert) {
            desserts.add((Dessert) dish);
        } else if (dish instanceof NonAlcoholDrink) {
            nonAlcoholDrinks.add((NonAlcoholDrink) dish);
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
            <% for (NonAlcoholDrink nonAlcoholDrink : nonAlcoholDrinks) {
                out.print("<p>" + nonAlcoholDrink.getName().toUpperCase() + "</p>");
                out.print("<p>" + nonAlcoholDrink.getCuisine().toLowerCase() + " cuisine" + "</p>");
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
