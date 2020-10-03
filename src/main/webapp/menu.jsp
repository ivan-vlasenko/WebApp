<%@ page import="model.MenuItemDao" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.dish.AlcoholDrink" %>
<%@ page import="entity.dish.NonAlcoholDrink" %>
<%@ page import="entity.dish.*" %>
<%@ page import="entity.dish.NonAlcoholDrink" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MenuItemDao menuItemDao = new MenuItemDao();
    List<MenuItem> menuItems = menuItemDao.getMenuItems();
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
            <%
                for (MenuItem appetizer : menuItems) {
                    if (appetizer instanceof Appetizer) {
                        out.print("<p>" + ((Appetizer) appetizer).getName().toUpperCase() + "</p>");
                        out.print("<p>" + ((Appetizer) appetizer).getCuisine().toLowerCase() + " cuisine" + "</p>");
                    }
                }
            %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>FIRST COURSE</h4>
            <br>
            <%
                for (MenuItem soup : menuItems) {
                    if (soup instanceof Soup) {
                        out.print("<p>" + ((Soup) soup).getName().toUpperCase() + "</p>");
                        out.print("<p>" + ((Soup) soup).getCuisine().toLowerCase() + " cuisine" + "</p>");
                    }
                }
            %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>MAIN COURSE</h4>
            <br>
            <%
                for (MenuItem mainMeal : menuItems) {
                    if (mainMeal instanceof MainMeal) {
                        out.print("<p>" + ((MainMeal) mainMeal).getName().toUpperCase() + "</p>");
                        out.print("<p>" + ((MainMeal) mainMeal).getCuisine().toLowerCase() + " cuisine" + "</p>");
                    }
                }
            %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>DESSERT</h4>
            <br>
            <%
                for (MenuItem dessert : menuItems) {
                    if (dessert instanceof Dessert) {
                        out.print("<p>" + ((Dessert) dessert).getName().toUpperCase() + "</p>");
                        out.print("<p>" + ((Dessert) dessert).getCuisine().toLowerCase() + " cuisine" + "</p>");
                    }
                }
            %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>NON-ALCOHOL DRINK</h4>
            <br>
            <%
                for (MenuItem nonAlcoholDrink : menuItems) {
                    if (nonAlcoholDrink instanceof NonAlcoholDrink) {
                        out.print("<p>" + ((NonAlcoholDrink) nonAlcoholDrink).getName().toUpperCase() + "</p>");
                        out.print("<p>" + ((NonAlcoholDrink) nonAlcoholDrink).getCuisine().toLowerCase() + " cuisine" + "</p>");
                    }
                }
            %>
            <br>
        </div>
    </div>
    <div align="middle">
        <div align="middle">
            <h4>ALCOHOL DRINK</h4>
            <br>
            <%
                for (MenuItem alcoholDrink : menuItems) {
                    if (alcoholDrink instanceof AlcoholDrink) {
                        out.print("<p>" + ((AlcoholDrink) alcoholDrink).getName().toUpperCase() + "</p>");
                        out.print("<p>" + ((AlcoholDrink) alcoholDrink).getCuisine().toLowerCase() + " cuisine" + "</p>");
                    }
                }
            %>
            <br>
        </div>
    </div>
</div>
</body>
</html>
