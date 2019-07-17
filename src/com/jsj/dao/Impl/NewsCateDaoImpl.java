package com.jsj.dao.Impl;

import com.jsj.dao.NewsCateDao;
import com.jsj.entity.NewsCate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewsCateDaoImpl implements NewsCateDao {

    @Override
    public List<NewsCate> getAll() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "select * from cate";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<NewsCate> newsCateList = new ArrayList<>();
        while (resultSet.next()){
            NewsCate newsCate = new NewsCate();
            newsCate.setId(resultSet.getInt("id"));
            newsCate.setName(resultSet.getString("name"));
            newsCateList.add(newsCate);
        }
        return newsCateList;
    }
}
