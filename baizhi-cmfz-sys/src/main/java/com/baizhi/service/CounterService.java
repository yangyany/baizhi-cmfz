package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/15.
 */
public interface CounterService {
    /**
     * 添加
     */
    public void save(Counter counter);
    /**
     * 查所有
     */
    public List<Counter> queryAll();
    /**
     * 根据id查一个
     */
    public Counter  queryById(String id);
    /**
     * 修改
     */
    public void update(Counter counter);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 分页查询
     */
    public Map queryCounterByPage(Integer page, Integer rows);

}
