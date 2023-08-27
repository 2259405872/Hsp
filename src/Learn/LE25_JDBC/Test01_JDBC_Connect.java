package Learn.LE25_JDBC;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//五种JDBC连接mysql的方式

public class Test01_JDBC_Connect {

    //方式一极为朴素，灵活性差，依赖性强
    @Test
    public void connect01() throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();

        //2.配置账户密码文件
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","yssyyc");

        //3.得到连接
        String url = "jdbc:mysql://localhost:3306/hsp";
        Connection connect = driver.connect(url, properties);

        //4.执行sql
        Statement statement = connect.createStatement();
        String sql = "insert into t01 values(111,'杨山')";
        int row = statement.executeUpdate(sql);
        System.out.println("一共"+row+"行被更改");

        //5.关闭连接
        statement.close();
        connect.close();
    }
    //方式二用到了反射，可以调用不同的数据库连接
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //1.反射注册驱动
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver)cls.newInstance();

        //2.配置账户密码文件
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","yssyyc");

        //3.得到连接
        String url = "jdbc:mysql://localhost:3306/hsp";
        Connection connect = driver.connect(url, properties);

        System.out.println(connect);
        /*

        //4.执行sql
        Statement statement = connect.createStatement();
        String sql = "insert into t01 values(111,'杨山')";
        int row = statement.executeUpdate(sql);
        System.out.println("一共"+row+"行被更改");

        //5.关闭连接
        statement.close();
        connect.close();
*/
    }

    //方式三用DriverManage获取连接
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //1.反射加载Driver
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver)cls.newInstance();

        //2.配置
        String user="root";
        String password="yssyyc";
        String url = "jdbc:mysql://localhost:3306/hsp";
        Properties properties = new Properties();
        properties.setProperty("user",user);
        properties.setProperty("password",password);

        //3.注册驱动，得到连接
        DriverManager.registerDriver(driver);
        Connection connect1 = DriverManager.getConnection(url, properties);//通过url+properties获取
        Connection connect2 = DriverManager.getConnection(url,user,password);//通过url+user+password获取
        System.out.println(connect1);
        System.out.println(connect2);
        /*

        //4.执行sql
        Statement statement = connect.createStatement();
        String sql = "insert into t01 values(111,'杨山')";
        int row = statement.executeUpdate(sql);
        System.out.println("一共"+row+"行被更改");

        //5.关闭连接
        statement.close();
        connect.close();
*/
    }

    //第四种方式省略了第三种方式的注册驱动
    //推荐使用
    @Test
    public void connect04() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //1.反射加载Driver
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver=(Driver)cls.newInstance();

        //2.配置
        String user="root";
        String password="yssyyc";
        String url = "jdbc:mysql://localhost:3306/hsp";
        Properties properties = new Properties();
        properties.setProperty("user",user);
        properties.setProperty("password",password);

        //3.直接得到连接
//        DriverManager.registerDriver(driver);//之所以能省略是因为在Driver类加载的时候，就有静态代码块执行了注册了
        Connection connect1 = DriverManager.getConnection(url, properties);//通过url+properties获取
        Connection connect2 = DriverManager.getConnection(url,user,password);//通过url+user+password获取
        System.out.println(connect1);
        System.out.println(connect2);
        /*

        //4.执行sql
        Statement statement = connect.createStatement();
        String sql = "insert into t01 values(111,'杨山')";
        int row = statement.executeUpdate(sql);
        System.out.println("一共"+row+"行被更改");

        //5.关闭连接
        statement.close();
        connect.close();
*/
    }

    //第五种方式省略，反射加载Driver类
    //这是因为java.sql.Driver文件里已经有Driver类的路径，编译器自动帮我们加载了Driver类，但有多个数据库时容易出错，所以不推荐使用
    @Test
    public void connect05() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //1.反射加载Driver，省略
//        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver=(Driver)cls.newInstance();

        //2.配置
        String user="root";
        String password="yssyyc";
        String url = "jdbc:mysql://localhost:3306/hsp";
        Properties properties = new Properties();
        properties.setProperty("user",user);
        properties.setProperty("password",password);

        //3.直接得到连接
//        DriverManager.registerDriver(driver);//之所以能省略是因为在Driver类加载的时候，就有静态代码块执行了注册了
        Connection connect1 = DriverManager.getConnection(url, properties);//通过url+properties获取
        Connection connect2 = DriverManager.getConnection(url,user,password);//通过url+user+password获取
        System.out.println(connect1);
        System.out.println(connect2);
        /*

        //4.执行sql
        Statement statement = connect.createStatement();
        String sql = "insert into t01 values(111,'杨山')";
        int row = statement.executeUpdate(sql);
        System.out.println("一共"+row+"行被更改");

        //5.关闭连接
        statement.close();
        connect.close();
*/
    }
}
