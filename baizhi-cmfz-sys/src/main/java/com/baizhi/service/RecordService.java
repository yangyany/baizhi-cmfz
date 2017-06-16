package com.baizhi.service;

import com.baizhi.entity.Record;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface RecordService {
    /**
     * 添加
     */
    public void save(Record record);
    /**
     * 查所有
     */
    public List<Record> queryAll();
    /**
     * 根据id查一个
     */
    public Record  queryById(String id);
    /**
     * 修改
     */
    public void update(Record record);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 分页查询
     */
    public Map queryRecordByPage(Integer page, Integer rows);
}
