package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface CityService {
    /**
     * 查一个
     */
    public City queryById(String id);
    /**
     * 查所有
     */
    public List<City> queryAll();
    /**
     * 修改
     */
    public void update(City city);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 添加
     */
    public void save(City city);
    /**
     * 分页查询
     */
    public Map queryCityByPage(Integer page, Integer rows);
}
