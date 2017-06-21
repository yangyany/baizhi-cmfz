package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Picture implements Serializable{
    private String id;
    private String title;
    private String name;
    private String type;

    public Picture() {
    }

    public Picture(String id, String title, String name, String type) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
