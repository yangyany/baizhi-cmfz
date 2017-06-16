package com.baizhi.service;

import com.baizhi.entity.Province;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface ProvinceService {
    /**
     * 查一个
     */
    public Province queryById(String id);
    /**
     * 查所有
     */
    public List<Province> queryAll();
    /**
     * 修改
     */
    public void update(Province province);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 添加
     */
    public void save(Province province);
    /**
     * 分页查询
     */
    public Map queryProvinceByPage(Integer page, Integer rows);


    /**
     * 分页查询
     */
    /*public Page<Province> queryProByPage(Integer pageNum, Integer pageSize);*/
}
