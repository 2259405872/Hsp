package smallProject.MHL.Dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import smallProject.MHL.Utils.JDBCUtils_Druid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//基础DAO其他DAO的父类
public class BasicDAO<T> {
    private QueryRunner qr=new QueryRunner();

    //开发通用的dml语言
    public int update(String sql,Object... parameters){
        Connection connection=  null;

        try {
            connection = JDBCUtils_Druid.getConnection();
            return qr.update(connection,sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }

    //返回多行结果，针对多个表
    public List<T> queryMultiple(String sql,Class<T> clazz,Object... parameters){
        Connection connection=  null;

        try {
            connection = JDBCUtils_Druid.getConnection();
            return qr.query(connection,sql, new BeanListHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }

    //返回单行
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection=  null;

        try {
            connection = JDBCUtils_Druid.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }

    //返回单值
    public Object queryScalar(String sql,Object... parameters){
        Connection connection=  null;

        try {
            connection = JDBCUtils_Druid.getConnection();
            return qr.query(connection,sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,null,connection);
        }
    }
}
