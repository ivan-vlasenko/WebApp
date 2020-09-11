package model;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.Dao.getConnection;

public class UserDao {
    private List<User> users;

    public UserDao() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public static int save(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        int status = 0;
        try {
            conn = getConnection();

            statement = conn.prepareStatement(
                    "insert into users(login, email, password) values (?,?,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            status = statement.executeUpdate();

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return status;
    }

    public static boolean loginDao(String log, String pass) {
        Connection con = null;
        try {
            con = getConnection();

            Statement st = con.createStatement();

            String query = "select user_id from users where login='" + log + "' and password='" + pass + "'";

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                rs.close();
                st.close();
                con.close();
                return true;
            }

            rs.close();
            st.close();
            con.close();
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}
