package a;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static String driverclass;
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(DBUtil.class.getClass().getResource("/").toURI().getPath().substring(1) + "config.properties"));
            driverclass = prop.getProperty("driverclass");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverclass);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载异常");
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
        }
        return conn;

    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {
        DBUtil.getConnection();


    }

}
