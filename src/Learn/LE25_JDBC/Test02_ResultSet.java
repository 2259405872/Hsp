package Learn.LE25_JDBC;

import java.sql.*;

//ResultSet接口是sql查询语句返回的行的集合，以迭代器的方式使用
public class Test02_ResultSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.反射加载Driver
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver=(Driver)cls.newInstance();

        //2.配置
        String user="root";
        String password="yssyyc";
        String url = "jdbc:mysql://localhost:3306/hsp";
        //3.直接得到连接
//        DriverManager.registerDriver(driver);//之所以能省略是因为在Driver类加载的时候，就有静态代码块执行了注册了
        Connection connect = DriverManager.getConnection(url,user,password);//通过url+user+password获取
        System.out.println(connect);

        //4.执行sql
        Statement statement = connect.createStatement();
        String sql = "Select * from t01";
        ResultSet resultSet = statement.executeQuery(sql);//返回了ResultSet

        while (resultSet.next()){
            int id = resultSet.getInt(1);//按列索引，获取第一列
            String name = resultSet.getString("name");//按列名获取第二列

            System.out.println(id+"\t"+name+"\t");
        }
        //5.关闭连接
        statement.close();
        connect.close();
    }
}
