package com.baizhi.dao;

import com.baizhi.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/14.
 */
public interface CityDAO extends BaseDAO<City> {
    /**
     * 根据省id查
     */
    public List<City> selectByProvinceid(String provinceid);
    /**
     * 分页查询
     */
    public List<City> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

}
