package Learn.LE25_JDBC.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

//德鲁伊连接池的基本使用
public class Test_DataSource_Druid {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Learn/LE25_JDBC/druid.properties"));

        //获取德鲁伊连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
    }
}
