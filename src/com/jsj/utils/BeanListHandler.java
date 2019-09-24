package com.jsj.utils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler extends ResultSetHandler {

    private Class<?> clazz;

    public BeanListHandler(Class<?> clazz){
        this.clazz = clazz;
    }

    @Override
    public List handle(ResultSet resultSet) throws Exception {
        List list = new ArrayList();
        while(resultSet.next()) {
            Object bean = buildObject(resultSet, clazz);
            list.add(bean);
        }
        return list;
    }
}
