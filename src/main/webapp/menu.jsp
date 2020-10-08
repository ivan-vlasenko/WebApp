<%@ page import="dao.MenuItemDao" %>
<%@ page import="java.util.List" %>
<%@ page import="model.menu.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MenuItemDao menuItemDao = new MenuItemDao();
    List<MenuItem> menuItems = menuItemDao.getMenuItems();
%>
<!doctype html>
<html lang="en">
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="index.jsp">HOME</a></li>
        <li><a href="menu">MENU</a></li>
        <li><a href="sign-in">LOGIN</a></li>
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
                    if (appetizer.getCategory().equals(MenuItemCategory.APPETIZER)) {
                        out.print("<p>" + appetizer.getName().toUpperCase() + "</p>");
                        out.print("<p>" + appetizer.getCuisine().toLowerCase() + " cuisine" + "</p>");
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
                    if (soup.getCategory().equals(MenuItemCategory.SOUP)) {
                        out.print("<p>" + soup.getName().toUpperCase() + "</p>");
                        out.print("<p>" + soup.getCuisine().toLowerCase() + " cuisine" + "</p>");
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
                    if (mainMeal.getCategory().equals(MenuItemCategory.MAIN_MEAL)) {
                        out.print("<p>" + mainMeal.getName().toUpperCase() + "</p>");
                        out.print("<p>" + mainMeal.getCuisine().toLowerCase() + " cuisine" + "</p>");
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
                    if (dessert.getCategory().equals(MenuItemCategory.DESSERT)) {
                        out.print("<p>" + dessert.getName().toUpperCase() + "</p>");
                        out.print("<p>" + dessert.getCuisine().toLowerCase() + " cuisine" + "</p>");
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
                for (MenuItem drink : menuItems) {
                    if (drink.getCategory().equals(MenuItemCategory.NON_ALCOHOL_DRINK)) {
                        out.print("<p>" + drink.getName().toUpperCase() + "</p>");
                        out.print("<p>" + drink.getCuisine().toLowerCase() + " cuisine" + "</p>");
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
                    if (alcoholDrink.getCategory().equals(MenuItemCategory.ALCOHOL_DRINK)) {
                        out.print("<p>" + alcoholDrink.getName().toUpperCase() + "</p>");
                        out.print("<p>" + alcoholDrink.getCuisine().toLowerCase() + " cuisine" + "</p>");
                    }
                }
            %>
            <br>
        </div>
    </div>
</div>
</body>
</html>
