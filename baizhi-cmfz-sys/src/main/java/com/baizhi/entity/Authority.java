package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by yanyan on 2017/6/20.
 */
public class Authority implements Serializable {
    private String id;
    private String name;

    public Authority() {
    }

    public Authority(String id, String name) {
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

    @Override
    public String toString() {
        return "Authority{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
