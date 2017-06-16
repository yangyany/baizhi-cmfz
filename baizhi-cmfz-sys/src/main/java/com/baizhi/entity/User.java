package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by yanyan on 2017/6/11.
 */
public class User implements Serializable{
    private String id;
    private String name;
    private String legalname;
    private String tel;
    private String sex;
    private String signature;
    private String picpath;
    private Province province;
    private City city;
    private String password;
    private String salt;
    private Teacher teacher;

    public User() {
    }

    public User(String id, String name, String legalname, String tel, String sex, String signature, String picpath, String password, String salt) {
        this.id = id;
        this.name = name;
        this.legalname = legalname;
        this.tel = tel;
        this.sex = sex;
        this.signature = signature;
        this.picpath = picpath;
        this.password = password;
        this.salt = salt;
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

    public String getLegalname() {
        return legalname;
    }

    public void setLegalname(String legalname) {
        this.legalname = legalname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", legalname='" + legalname + '\'' +
                ", tel='" + tel + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                ", picpath='" + picpath + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
