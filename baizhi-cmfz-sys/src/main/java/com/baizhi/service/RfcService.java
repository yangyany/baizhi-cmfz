package com.baizhi.service;

import java.util.Map;

/**
 * Created by yanyan on 2017/6/15.
 */
public interface RfcService {
    /**
     * 分頁查所有
     */
    public Map queryRfcByPage(Integer page, Integer rows);
}
