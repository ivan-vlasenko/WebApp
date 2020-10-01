package model;

import entity.user.User;

import java.sql.*;



public class UserDao {

    public static int save(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        int status = 0;
        try {
            conn = DaoUtils.getConnection();
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(
                    "insert into users(login, email, password) values (?,?,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            DaoUtils.rollbackQuietly(conn);
        } finally {
            DaoUtils.closeQuietly(statement, conn);
        }

        return status;
    }

    public static boolean login(String log, String pass, String email) {
        Connection con;
        try {
            con = DaoUtils.getConnection();

            Statement st = con.createStatement();

            String query = "select user_id from users where login='" + log + "' " +
                    "and password='" + pass + "' " +
                    "and email='" + email + "'";

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                DaoUtils.closeQuietly(rs, st, con);
                return true;
            }

            DaoUtils.closeQuietly(rs, st, con);
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public User getUserByLogin(String log) {
        User user = null;

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = DaoUtils.getConnection();
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(
                    "select from users (login, email, password) where (login = ?)");
            statement.setString(1, log);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String login = resultSet.getString(1);
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                user = new User(login, email, password);
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

        return user;
    }
}
