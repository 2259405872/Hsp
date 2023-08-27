package Learn.LE25_JDBC.Statement;

import java.sql.*;
import java.util.Scanner;

//Statment在企业开发中几乎用不到，因为它采用字符串拼接的方式，所以用户输入的数据也有可能被识别成sql关键字，形成sql注入非常不安全
public class Test01_Statement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        //1.反射加载Driver
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver=(Driver)cls.newInstance();

        //2.配置
        String user="root";
        String password="yssyyc";
        String url = "jdbc:mysql://localhost:3306/hsp";
        System.out.print("请输入，你想查询的用户id:");
        int id=input.nextInt();
        //3.直接得到连接
//        DriverManager.registerDriver(driver);//之所以能省略是因为在Driver类加载的时候，就有静态代码块执行了注册了
        Connection connect = DriverManager.getConnection(url,user,password);//通过url+user+password获取
        System.out.println(connect);

        //4.执行sql
        Statement statement = connect.createStatement();
        String sql = "Select * from t01 where id="+id;
        ResultSet resultSet = statement.executeQuery(sql);//返回了ResultSet

        while (resultSet.next()){
            int id1 = resultSet.getInt(1);//按列索引，获取第一列
            String name = resultSet.getString("name");//按列名获取第二列

            System.out.println(id1+"\t"+name+"\t");
        }
        //5.关闭连接
        statement.close();
        connect.close();
    }
}
