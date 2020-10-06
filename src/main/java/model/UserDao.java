package model;

import entity.user.User;

import java.sql.*;



public class UserDao {

    public static boolean saveUser(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        boolean status = false;
        try {
            conn = DaoUtils.getConnection();
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(
                    "insert into users(login, email, password) values (?,?,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate() > 0;

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

            String query = "select id from users where login='" + log + "' " +
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

    public static boolean deleteUser(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        boolean status = false;
        try {
            conn = DaoUtils.getConnection();
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(
                    "delete from users where login=?"
                            +"and email=?"
                            +"and password=?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate() > 0;

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

    public static boolean updateUser(User currentUser, String newLogin, String newPass, String newEmail) {
        Connection conn = null;
        PreparedStatement statement = null;
        boolean status = false;
        try {
            conn = DaoUtils.getConnection();
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(
                    "update users set login=?, password=?, email=? where login=?");
            statement.setString(1, newLogin);
            statement.setString(2, newPass);
            statement.setString(3, newEmail);
            statement.setString(4, currentUser.getLogin());

            status = statement.executeUpdate() > 0;

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
}
