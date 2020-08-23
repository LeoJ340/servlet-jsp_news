package com.jsj.entity;

import java.util.Objects;

public class NewsCate {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsCate newsCate = (NewsCate) o;
        return id.equals(newsCate.id) &&
                name.equals(newsCate.name);
    }
}
