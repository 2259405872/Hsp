package Learn.LE25_JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils_Druid {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/Learn/LE25/Druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //释放资源
    public static void close(ResultSet set, Statement statement, Connection connection){
        try {
            if (set!=null) {
                set.close();
            } else if (statement!=null){
                statement.close();
            } else if ( connection!=null){
                connection.close();//连接池获取的connection关闭时，只是把连接放回连接池，而不是真正地释放资源
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
