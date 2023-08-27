package Learn.LE25_JDBC.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//c3p0连接池的连接与使用
//c3p0连接池较为稳定但速度比较慢
//连接池为我们提供了多个预先准备好的连接，以防短时间多次访问，和连接数过多
public class Test_DataSource_C3p0 {

    //连接方式一，手动连接，不推荐
    public void connect01() throws IOException, PropertyVetoException, SQLException {
        Properties info = new Properties();
        info.load(new FileInputStream("src/Learn/LE25_JDBC/mysql.properties"));
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String url = info.getProperty("url");
        String driver = info.getProperty("driver");

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();//创建连接池

        //设置连接池信息
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        Connection connection = comboPooledDataSource.getConnection();//得到连接
        connection.close();
    }
    //连接方式二,使用配置文件连接，推荐使用
    public void connect02() throws SQLException {
        ComboPooledDataSource ys = new ComboPooledDataSource("ys");

        Connection connection = ys.getConnection();
        connection.close();
    }
}
