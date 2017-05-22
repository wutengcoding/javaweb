package com.wutengcoding.mvcapp.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wuteng on 2017/5/17.
 */
public class JdbcUtils {

    private static DataSource dataSource = null;

    static{
        dataSource = new ComboPooledDataSource("mvcapp");
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) {
        try {
            System.out.println(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
