package com.baizhi.entity;

/**
 * Created by yanyan on 2017/6/12.
 */
public class Teacher {
    private String id;
    private String name;
    private String picpath;

    public Teacher() {
    }

    public Teacher(String id, String name, String picpath) {
        this.id = id;
        this.name = name;
        this.picpath = picpath;
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

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picpath='" + picpath + '\'' +
                '}';
    }
}
