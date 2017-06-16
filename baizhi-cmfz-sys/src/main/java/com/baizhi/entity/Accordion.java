package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yanyan on 2017/6/11.
 */
public class Accordion implements Serializable{
    private String id;
    private String name;
    private String iconCls;
    private String href;
    private List<Accordion> children;

    public Accordion() {
    }

    public Accordion(String id, String name, String iconCls, String href) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Accordion> getChildren() {
        return children;
    }

    public void setChildren(List<Accordion> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Accordion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
