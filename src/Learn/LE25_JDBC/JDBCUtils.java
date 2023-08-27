package Learn.LE25_JDBC;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    static {
        try {
            Properties info = new Properties();
            info.load(new FileInputStream("src/Learn/LE25_JDBC/mysql.properties"));
            user = info.getProperty("user");
            password = info.getProperty("password");
            url = info.getProperty("url");
            driver = info.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //释放资源
    public static void close(ResultSet set, Statement statement,Connection connection){
        try {
            if (set!=null) {
                set.close();
            } else if (statement!=null){
                statement.close();
            } else if ( connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


