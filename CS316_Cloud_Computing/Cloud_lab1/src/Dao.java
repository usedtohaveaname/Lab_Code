import java.sql.*;
public class Dao {
    public  Dao(){}
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://155.138.128.229:3306/cs316";
    //用户名
    private static final String USER_NAME = "user1";
    //密码
    private static final String PASSWORD = "user123456";
    public boolean login_authenticate(String username, String password) {
        Connection connection = null;
        try {
            //get connection to database
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //execute mysql query
            String sql = "SELECT username, password FROM users where username = \""
                    + username + "\" and password =\"" + password+"\"";
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                System.out.println("用户名:" + rs.getString("username"));
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
        return true;
    }
    public boolean register_user(String username, String password){
        Connection connection = null;
        Statement stmt = null;
        try {

            //get connection to database
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            stmt = connection.createStatement();
            //insert user info to database
            String sql = "insert into users (username, password)values" +
                    "(\""+username+"\",\""+password+"\")";
            stmt.execute(sql);

        } catch (SQLException se) {
            se.printStackTrace();
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
