package model;

import entity.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DishDao {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MySQL_PATH = "jdbc:mysql://localhost:3306/restaurant";
    private static final String LOGIN = "root";
    private static final String PASS = "635805";

    private List<Dish> dishes;

    public DishDao() {
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

            resultSet = statement.executeQuery("SELECT id, name FROM dishes");

            if (statement.execute("SELECT id, name FROM dishes")) {
                resultSet = statement.getResultSet();
            }

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                dishes.add(new Dish(id, name));
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
