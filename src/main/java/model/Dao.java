package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
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
}
