package com.jsj.utils;

import java.sql.ResultSet;

public class BeanHandler extends ResultSetHandler {

    private Class<?> clazz;

    public BeanHandler(Class<?> clazz){
        this.clazz = clazz;
    }

    @Override
    public Object handle(ResultSet resultSet) throws Exception {
        if (resultSet.next()){
            return buildObject(resultSet, clazz);
        }else {
            return null;
        }
    }

}
