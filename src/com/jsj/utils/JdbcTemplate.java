package com.jsj.utils;

import java.sql.*;

public class JdbcTemplate {

    private JdbcTemplate(){
    }

    /**
     * 更新方法
     */
    public static int update(String sql, Object ...params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            for (int i = 1; i <= params.length; i++){
                preparedStatement.setObject(i, params [i-1]);
            }
            return preparedStatement.executeUpdate();
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
    }

    /**
     * 查询方法
     */
    public static Object query(String sql, ResultSetHandler handler, Object... params) throws Exception {
        Connection connection = JdbcUtils.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            for (int i = 1; i <= params.length; i++){
                preparedStatement.setObject(i, params [i-1]);
            }
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                return handler.handle(resultSet);
            }
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
    }

    public static int queryCount(String sql, Object... params) throws Exception{
        Connection connection = JdbcUtils.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            for (int i = 1; i <= params.length; i++){
                preparedStatement.setObject(i, params [i-1]);
            }
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    return resultSet.getInt(1);
                }else {
                    return -1;
                }
            }
        }finally {
            JdbcUtils.releaseConnection(connection);
        }
    }

}
