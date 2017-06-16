package com.baizhi.dao;

import com.baizhi.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface RecordDAO extends BaseDAO<Record> {
    /**
     * 分页查询
     */
    public List<Record> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
