package com.baizhi.service.impl;

import com.baizhi.dao.CounterDAO;
import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yanyan on 2017/6/15.
 */
@Service("counterService")
@Transactional
public class CounterServiceImpl implements CounterService {
    @Autowired
    private CounterDAO counterDAO;

    public void save(Counter counter) {
        counter.setId(UUID.randomUUID().toString());
        counterDAO.insert(counter);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Counter> queryAll() {

        return counterDAO.selectAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Counter queryById(String id) {
        return counterDAO.selectById(id);
    }

    public void update(Counter counter) {
        counterDAO.update(counter);
    }

    public void delete(String id) {
        counterDAO.delete(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryCounterByPage(Integer page, Integer rows) {
        List<Counter> counters = counterDAO.queryByPage((page - 1) * rows, rows);
        Integer total = counterDAO.selectAll().size();

        Map map = new HashMap();
        map.put("rows",counters);
        map.put("total",total);
        return map;
    }
}
