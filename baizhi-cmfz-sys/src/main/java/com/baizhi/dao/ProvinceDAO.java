package com.baizhi.dao;

import com.baizhi.entity.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface ProvinceDAO extends BaseDAO<Province>{
    /**
     * 分页查询
     */

    public List<Province> queryByPage(@Param("page") Integer pageSize,@Param("rows") Integer pageNum);
}
