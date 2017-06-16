package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyan on 2017/6/12.
 */
public interface UserDAO extends BaseDAO<User> {
    /**
     * 分页查询
     */
    public List<User> queryByPage(@Param("page") Integer pageSize, @Param("rows")Integer pageNum);

    /**
     *
     */
    public User selectLegalname(String id);
}
