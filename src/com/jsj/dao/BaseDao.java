package com.jsj.dao;

import java.util.List;

public interface BaseDao<T> {

    List<T> getAll();

    T getById(Integer id);

    int insert(T t);

    int deleteById(Integer id);

    int update(T t);
}
