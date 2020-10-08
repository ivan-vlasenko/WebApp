package dao;

import model.user.User;

import java.sql.*;



public class UserDao {
    private static final String INSERT_USER = "insert into users(login, email, password) values (?,?,?)";
    private static final String LOGIN_USER = "select id from users where login=? and password=? and email=?";
    private static final String DELETE_USER = "delete from users where login=? and email=? and password=?";
    private static final String UPDATE_USER = "update users set login=?, password=?, email=? where login=?";

    private static Connection jdbcConnection = null;
    private static PreparedStatement statement = null;

    private static boolean status = false;


    public static boolean saveUser(User user) {
        try {
            jdbcConnection = DaoUtils.getConnection();
            jdbcConnection.setAutoCommit(false);

            statement = jdbcConnection.prepareStatement(INSERT_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate() > 0;

            jdbcConnection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(jdbcConnection);
        } finally {
            DaoUtils.closeQuietly(statement, jdbcConnection);
        }

        return status;
    }

    public static boolean login(User user) {
        ResultSet resultSet = null;
        try {
            jdbcConnection = DaoUtils.getConnection();

            statement = jdbcConnection.prepareStatement(LOGIN_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());


            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DaoUtils.closeQuietly(resultSet, statement, jdbcConnection);
                return true;
            }

            DaoUtils.closeQuietly(resultSet, statement, jdbcConnection);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteUser(User user) {
        try {
            jdbcConnection = DaoUtils.getConnection();
            jdbcConnection.setAutoCommit(false);

            statement = jdbcConnection.prepareStatement(DELETE_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate() > 0;

            jdbcConnection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(jdbcConnection);
        } finally {
            DaoUtils.closeQuietly(statement, jdbcConnection);
        }

        return status;
    }

    public static boolean updateUser(User currentUser, String updateLogin, String updatePass, String updateEmail) {
        try {
            jdbcConnection = DaoUtils.getConnection();
            jdbcConnection.setAutoCommit(false);

            statement = jdbcConnection.prepareStatement(UPDATE_USER);
            statement.setString(1, updateLogin);
            statement.setString(2, updatePass);
            statement.setString(3, updateEmail);
            statement.setString(4, currentUser.getLogin());

            status = statement.executeUpdate() > 0;

            jdbcConnection.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(jdbcConnection);
        } finally {
            DaoUtils.closeQuietly(statement, jdbcConnection);
        }

        return status;
    }
}
