package Learn.LE25_JDBC.Statement;

import java.sql.*;
import java.util.Scanner;

public class Test02_PreparedStatement {
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
        String sql = "Select * from t01 where id=?";
        PreparedStatement statement = connect.prepareStatement(sql);
        //给sql语句里的？赋值
        statement.setInt(1,id);//这里的“1”指代第一个？

        ResultSet resultSet = statement.executeQuery();//返回了ResultSet，且没传入参数sql

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
