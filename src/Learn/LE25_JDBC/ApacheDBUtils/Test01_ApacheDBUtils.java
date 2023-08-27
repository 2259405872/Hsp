package Learn.LE25_JDBC.ApacheDBUtils;

//ApacheDBUtils
//解决了，Connection关闭后ResultSet无法使用且使用不便地问题
//极大地便利了JDBC的使用
//它能将查询语句结果的每一行封装到一个Actor类里面

import Learn.LE25_JDBC.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Test01_ApacheDBUtils {

    //使用AppacheDBUtils
    public void test1() throws SQLException {
        Connection connection = JDBCUtils_Druid.getConnection();
        //1.创建queryRunner
        QueryRunner queryRunner = new QueryRunner();

        //2.1查询单行并封装到一个javaBean里面
        String sql = "select * from account where name=?";
        //这里的类名不是Actor也行只要与查询结果对应就行
        Actor xj = queryRunner.query(connection, sql, new BeanHandler<Actor>(Actor.class), "向进");//向进是传入sql的参数
        System.out.println(xj);

        //2.2查询多行并封装到一个List<Actor>里面
        String sql1 = "select * from account";
        List<Actor> list = queryRunner.query(connection, sql1, new BeanListHandler<Actor>(Actor.class));
        System.out.println(list);

        //2.3查询一个格子的值并获取
        String sql2 = "select money from account where name=?";
        Object wyx = queryRunner.query(connection, sql2, new ScalarHandler<>(), "魏玉鑫");
        System.out.println(wyx);

        //2.4执行dml语句
        String sql3 = "insert into account (103,'杨山',4000)";
        int update = queryRunner.update(connection, sql3);//返回的值代表改变的行数，负值代表执行失败


    }
}
