package model;

import entity.dish.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MenuItemDao {

    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = DaoUtils.getConnection();
            conn.setAutoCommit(false);

            statement = conn.createStatement();

            resultSet = statement.executeQuery("SELECT name, cuisine, category FROM menu");

            if (statement.execute("SELECT name, cuisine, category FROM menu")) {
                resultSet = statement.getResultSet();
            }

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String cuisine = resultSet.getString("cuisine");
                String category = resultSet.getString("category");

                menuItems.add(MenuItemFactory.createMenuItem(name, cuisine, category));
            }

            conn.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(conn);
        } finally {
            DaoUtils.closeQuietly(resultSet, statement, conn);
        }
        return menuItems;
    }
}
