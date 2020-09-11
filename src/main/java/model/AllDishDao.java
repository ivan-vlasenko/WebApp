package model;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AllDishDao {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MySQL_PATH = "jdbc:mysql://localhost:3306/restaurant";
    private static final String LOGIN = "root";
    private static final String PASS = "635805";

    private List<Dish> dishes;

    public AllDishDao() {
        dishes = new ArrayList<>();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void dataBase() {
        Connection conn;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = DriverManager.getConnection(MySQL_PATH, LOGIN, PASS);

            statement = conn.createStatement();

            resultSet = statement.executeQuery("SELECT name, cuisine, category FROM menu");

            if (statement.execute("SELECT name, cuisine, category FROM menu")) {
                resultSet = statement.getResultSet();
            }

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String cuisine = resultSet.getString("cuisine");
                String category = resultSet.getString("category");
                if (category.equalsIgnoreCase("Main")) {
                    dishes.add(new MainDish(name, cuisine, category));
                } else if (category.equalsIgnoreCase("dessert")) {
                    dishes.add(new Dessert(name, cuisine, category));
                } else if (category.equalsIgnoreCase("appetizer")) {
                    dishes.add(new Appetizer(name, cuisine, category));
                } else if (category.equalsIgnoreCase("drink")) {
                    dishes.add(new Drink(name, cuisine, category));
                } else if (category.equalsIgnoreCase("alcohol drink")) {
                    dishes.add(new AlcoholDrink(name, cuisine, category));
                } else if (category.equalsIgnoreCase("soup")) {
                    dishes.add(new Soup(name, cuisine, category));
                }

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {
                }
                resultSet = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                }
                statement = null;
            }
        }
    }

    public void driverRegister() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
