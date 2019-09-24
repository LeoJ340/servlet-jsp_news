package com.jsj.dao;

import java.util.List;

public interface BaseDao<T> {

    default List<T> getAll() throws Exception {
        return null;
    }

    default T getById(Integer id) throws Exception {
        return null;
    }

    default int insert(T t) throws Exception {
        return 0;
    }

    default int deleteById(Integer id) throws Exception {
        return 0;
    }

    default int update(T t) throws Exception {
        return 0;
    }
}
