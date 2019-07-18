package com.jsj.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {

    default List<T> getAll() throws SQLException {
        return null;
    }

    default T getById(Integer id) throws SQLException {
        return null;
    }

    default int insert(T t) throws SQLException {
        return 0;
    }

    default int deleteById(Integer id){
        return 0;
    }

    default int update(T t) throws SQLException {
        return 0;
    }
}
