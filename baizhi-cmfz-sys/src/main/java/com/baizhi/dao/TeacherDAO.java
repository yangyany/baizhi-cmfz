package com.baizhi.dao;

import com.baizhi.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/12.
 */
public interface TeacherDAO extends BaseDAO<Teacher> {
    /**
     * 分页查询
     */
    public List<Teacher> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);
}
