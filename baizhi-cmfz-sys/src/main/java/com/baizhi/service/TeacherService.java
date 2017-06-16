package com.baizhi.service;

import com.baizhi.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/12.
 */
public interface TeacherService {
    /**
     * 添加
     */
    public void save(Teacher teacher);
    /**
     * 查所有
     */
    public List<Teacher> queryAll();
    /**
     * 根据id查一个
     */
    public Teacher  queryById(String id);
    /**
     * 修改
     */
    public void update(Teacher teacher);
    /**
     * 删除
     */
    public void delete(String id);
    /**
     * 分页查询
     */
    public Map queryTeacherByPage(Integer page, Integer rows);
}
