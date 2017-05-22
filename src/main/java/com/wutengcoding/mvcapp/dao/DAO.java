package com.wutengcoding.mvcapp.dao;

import com.wutengcoding.mvcapp.db.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wuteng on 2017/5/17.
 */
public class DAO<T> {

    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> clazz;

    public DAO() {

        Type genericSuperclass = getClass().getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                if (actualTypeArguments[0] instanceof Class) {
                    clazz = (Class<T>)actualTypeArguments[0];
                }
            }
        }
    }

    public <E> E getForValue(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return (E)queryRunner.query(connection, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }
    /**
     * get for a list
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }

        return null;
    }

    /**
     * get for a object
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    public void update(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();
            queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.releaseConnection(connection);
        }

    }
}
