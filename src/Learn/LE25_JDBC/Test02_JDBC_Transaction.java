package Learn.LE25_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//演示使用JDBC控制MySQL的事务机制
//这样能避免，因程序异常而产生的异常更改
public class Test02_JDBC_Transaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);//将事务自动提交关闭
        PreparedStatement preparedStatement = null;
        try {
            //开始转账
            String sql = "update Account set money=money-100 where id=?";
            String sql2 = "update Account set money=money+100 where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,100);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1,101);
        } catch (Exception e) {
            connection.rollback();//如果发生异常就回滚
            throw new RuntimeException(e);
        }finally {
            connection.commit();//提交事务
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
