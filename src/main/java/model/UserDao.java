package model;

import entity.user.User;

import java.sql.*;



public class UserDao {
    private static final String INSERT_USER = "insert into users(login, email, password) values (?,?,?)";
    private static final String LOGIN_USER = "select id from users where login=? and password=? and email=?";
    private static final String DELETE_USER = "delete from users where login=? and email=? and password=?";
    private static final String UPDATE_USER = "update users set login=?, password=?, email=? where login=?";

    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;
    static boolean status = false;


    public static boolean saveUser(User user) {
        try {
            connection = DaoUtils.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate() > 0;

            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(connection);
        } finally {
            DaoUtils.closeQuietly(statement, connection);
        }

        return status;
    }

    public static boolean login(String log, String pass, String email) {
        try {
            connection = DaoUtils.getConnection();

            statement = connection.prepareStatement(LOGIN_USER);
            statement.setString(1, log);
            statement.setString(2, pass);
            statement.setString(3, email);


            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DaoUtils.closeQuietly(resultSet, statement, connection);
                return true;
            }

            DaoUtils.closeQuietly(resultSet, statement, connection);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteUser(User user) {
        try {
            connection = DaoUtils.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(DELETE_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate() > 0;

            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(connection);
        } finally {
            DaoUtils.closeQuietly(statement, connection);
        }

        return status;
    }

    public static boolean updateUser(User currentUser, String updateLogin, String updatePass, String updateEmail) {
        try {
            connection = DaoUtils.getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, updateLogin);
            statement.setString(2, updatePass);
            statement.setString(3, updateEmail);
            statement.setString(4, currentUser.getLogin());

            status = statement.executeUpdate() > 0;

            connection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(connection);
        } finally {
            DaoUtils.closeQuietly(statement, connection);
        }

        return status;
    }
}
