package com.jsj.entity;

import java.util.List;

/**
 * 新闻分类所属的新闻列表
 */
public class NewsCateVo {

    private Integer cateId;

    private String name;

    private List<News> news;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

}
