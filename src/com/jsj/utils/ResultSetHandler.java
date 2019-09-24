package com.jsj.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;

abstract class ResultSetHandler {

    abstract Object handle(ResultSet resultSet) throws Exception;

    Object buildObject(ResultSet resultSet, Class<?> clazz) throws Exception {
        Object bean = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        // 封装数据
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i ++) {
            Object value = resultSet.getObject(i);
            //匹配实体类中对应的属性
            for (Field field : fields) {
                if (resultSet.getMetaData().getColumnName(i).replaceAll("_","").equals(field.getName().toLowerCase())) {
                    boolean flag = field.isAccessible();
                    field.setAccessible(true);
                    field.set(bean, value);
                    field.setAccessible(flag);
                    break;
                }
            }
        }
        return bean;
    }

}
