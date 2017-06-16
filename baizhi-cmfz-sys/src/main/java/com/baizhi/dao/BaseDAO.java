package com.baizhi.dao;

import java.util.List;

/**
 * Created by yanyan on 2017/6/11.
 */
public interface BaseDAO<T> {
    /**
     * 添加
     */
    public void insert(T t);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 修改
     */
    public void update(T t);
    /**
     * 查一个
     */
    public T selectById(String id);
    /**
     * 查所有
     */
    public List<T> selectAll();

}
