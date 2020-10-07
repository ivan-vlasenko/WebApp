package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoUtils {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MySQL_PATH = "jdbc:mysql://localhost:3306/";
    private static final String DB = "restaurant";
    private static final String LOGIN = "root";
    private static final String PASS = "635805";


    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(MySQL_PATH+DB,LOGIN,PASS);
        } catch(Exception e){
            System.out.println(e.toString());
        }
        return con;
    }

    public static void closeQuietly(AutoCloseable... resources) {
        for (AutoCloseable closeable : resources) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception sqlEx) {
                    System.out.println(sqlEx.getMessage());
                }
                closeable = null;
            }
        }
    }

    public static void rollbackQuietly(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            connection = null;
        }
    }
}
