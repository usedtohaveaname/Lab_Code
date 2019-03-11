package main.java;

import main.resources.BCrypt;
import java.sql.*;

public class Dao {
    public  Dao(){}
    private static final String URL = "jdbc:mysql://155.138.128.229:3306/cs316";
    private static final String USER_NAME = "user1";
    private static final String PASSWORD = "user123456";

    public boolean login_authenticate(String username, String password) {
        Connection connection = null;
        try {
            //get connection to database
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //execute mysql query
            String sql = "SELECT username, password FROM users where username = \""
                    + username + "\"";
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            if(rs.next()) {
                System.out.println("get password:" + rs.getString("password"));
                if (BCrypt.checkpw(password, rs.getString("password"))) {
                    rs.close();
                    prst.close();
                    return true;
                } else {
                    rs.close();
                    prst.close();
                    return false;
                }
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public boolean register_user(String username, String password){
        Connection connection = null;
        Statement stmt = null;
        try {

            //get connection to database
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            stmt = connection.createStatement();
            //insert user info to database
            String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
            String sql = "insert into users (username, password)values" +
                    "(\""+username+"\",\""+hashed+"\")";
            stmt.execute(sql);

        } catch (SQLException se) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //e.printStackTrace();
                }
            }
            return false;
            //se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.login_authenticate("root","root");
    }
}
