package com.jsj.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * jdbc工具类
 */
public class JdbcUtils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConnection() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection!=null){
            return transactionConnection;
        }
        return dataSource.getConnection();
    }

    /**
     * 开启事务
     */
    public static void beginTransaction() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection!=null){
            throw new SQLException("事务已开启");
        }
        transactionConnection = getConnection();
        transactionConnection.setAutoCommit(false);
        threadLocal.set(transactionConnection);
    }

    /**
     * 提交事务
     */
    public static void commitTransaction() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection==null){
            throw new SQLException("事务未开启");
        }
        transactionConnection.commit();
        transactionConnection.close();
        threadLocal.remove();
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection==null){
            throw new SQLException("事务未开启");
        }
        transactionConnection.rollback();
        transactionConnection.close();
        threadLocal.remove();
    }

    /**
     * 释放连接资源
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        if (threadLocal.get()==null){
            connection.close();
            return;
        }
        if (connection!=threadLocal.get()){
            connection.close();
        }
    }
}
