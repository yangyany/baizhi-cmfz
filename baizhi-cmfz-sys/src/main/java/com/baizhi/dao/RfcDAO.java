package com.baizhi.dao;

import com.baizhi.entity.Rfc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/15.
 */
public interface RfcDAO extends BaseDAO<Rfc>{
    /**
     * 分页查询
     */
    public List<Rfc> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
