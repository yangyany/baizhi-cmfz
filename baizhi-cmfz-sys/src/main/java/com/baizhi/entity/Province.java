package com.baizhi.entity;

import java.util.List;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Province {
    private String id;
    private String name;

    private List<City> citys;
    public Province() {
    }

    public Province(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
