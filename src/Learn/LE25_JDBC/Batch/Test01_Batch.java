package Learn.LE25_JDBC.Batch;

import Learn.LE25_JDBC.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//批处理使用演示
//批处理,将多个sql事务整合到一起，存入一个列表中集中发送到mysql服务器，极大减少传输的次数,提升效率
//要使用批处理必须在url里加上rewriteBatchedStatements=true
public class Test01_Batch {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into account values(?,?,2000)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 5001; i++) {
            preparedStatement.setInt(1,103+i);
            preparedStatement.setString(2,"y"+i);

            preparedStatement.addBatch();//将sql语句加入batch
            if (i%1000 == 0) {
                preparedStatement.executeBatch();//传输运行batch中存在的sql语句
            }
        }
        JDBCUtils.close(null, preparedStatement,connection);//释放资源
    }
}
