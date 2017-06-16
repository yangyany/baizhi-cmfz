package com.baizhi.dao;

import com.baizhi.entity.Counter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/15.
 */
public interface CounterDAO extends BaseDAO<Counter> {
    /**
     * 分页查询
     */
    public List<Counter> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
