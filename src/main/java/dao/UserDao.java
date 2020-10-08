package dao;

import model.user.User;

import java.sql.*;



public class UserDao {
    private static final String INSERT_USER = "insert into users(login, email, password) values (?,?,?)";
    private static final String LOGIN_USER = "select id from users where login=? and password=? and email=?";
    private static final String DELETE_USER = "delete from users where login=? and email=? and password=?";
    private static final String UPDATE_USER = "update users set login=?, password=?, email=? where login=?";

    public boolean saveUser(User user) {
        Connection jdbcConnection = null;
        PreparedStatement statement = null;

        boolean status = false;
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
            ex.printStackTrace();

            DaoUtils.rollbackQuietly(jdbcConnection);
        } finally {
            DaoUtils.closeQuietly(statement, jdbcConnection);
        }

        return status;
    }

    public boolean login(User user) {
        Connection jdbcConnection = null;
        PreparedStatement statement = null;
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
        } finally {
            DaoUtils.closeQuietly(resultSet, statement, jdbcConnection);
        }
        return false;
    }

    public boolean deleteUser(User user) {
        Connection jdbcConnection = null;
        PreparedStatement statement = null;

        boolean status = false;
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
            ex.printStackTrace();

            DaoUtils.rollbackQuietly(jdbcConnection);
        } finally {
            DaoUtils.closeQuietly(statement, jdbcConnection);
        }

        return status;
    }

    public boolean updateUser(User currentUser, String updateLogin, String updatePass, String updateEmail) {
        Connection jdbcConnection = null;
        PreparedStatement statement = null;

        boolean status = false;
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
            ex.printStackTrace();

            DaoUtils.rollbackQuietly(jdbcConnection);
        } finally {
            DaoUtils.closeQuietly(statement, jdbcConnection);
        }

        return status;
    }
}
