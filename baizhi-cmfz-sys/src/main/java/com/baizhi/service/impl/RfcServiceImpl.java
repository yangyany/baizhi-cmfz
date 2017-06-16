package com.baizhi.service.impl;

import com.baizhi.dao.RfcDAO;
import com.baizhi.entity.Rfc;
import com.baizhi.service.RfcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/15.
 */
@Service("rfcService")
@Transactional
public class RfcServiceImpl implements RfcService {
    @Autowired
    private RfcDAO rfcDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryRfcByPage(Integer page, Integer rows) {
        List<Rfc> rfcs = rfcDAO.queryByPage((page - 1) * rows, rows);
       Integer total = rfcDAO.selectAll().size();

        Map map = new HashMap();
        map.put("rows",rfcs);
        map.put("total",total);
        return map;
    }
}
