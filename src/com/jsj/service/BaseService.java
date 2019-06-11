package com.jsj.service;

import java.util.List;

public interface BaseService<T> {

    List<T> getAll();

    T getById(Integer id);

    int insert(T t);

    int deleteById(Integer id);

    int update(T t);
}
