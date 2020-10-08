package dao;

import model.menu.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MenuItemDao {
    private static final String SELECT_MENU_ITEMS = "SELECT name, cuisine, category FROM menu";

    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = DaoUtils.getConnection();
            conn.setAutoCommit(false);

            statement = conn.createStatement();

            resultSet = statement.executeQuery(SELECT_MENU_ITEMS);

            if (statement.execute(SELECT_MENU_ITEMS)) {
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
            ex.printStackTrace();

            DaoUtils.rollbackQuietly(conn);
        } finally {
            DaoUtils.closeQuietly(resultSet, statement, conn);
        }
        return menuItems;
    }
}
