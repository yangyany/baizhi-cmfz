package com.baizhi.controller;

import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/15.
 */
@Controller
@RequestMapping("/counter")
public class CounterController {
    @Resource
    private CounterService counterService;

    /**
     * 添加
     */
    @RequestMapping("/saveCounter")
    public void saveCounter(Counter counter){
        counterService.save(counter);
    }
    /**
     * 查所有
     */
    @RequestMapping("/queryAllCounters")
    @ResponseBody
    public List<Counter> queryAllCounters(){
        return counterService.queryAll();
    }
    /**
     * 根据id查一个
     */
    @RequestMapping("/queryOneCounter")
    @ResponseBody
    public Counter  queryOneCounter(String id){
        return counterService.queryById(id);
    }
    /**
     * 修改
     */
    @RequestMapping("/updateCounter")
    public void updateCounter(Counter counter){
        counterService.update(counter);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteCounter")
    public void deleteCounter(String id){
        counterService.delete(id);
    }
    /**
     * 分页查询
     */
    @RequestMapping("/queryCountByPage")
    @ResponseBody
    public Map queryCountByPage(Integer page, Integer rows){
        Map map = counterService.queryCounterByPage(page, rows);
        return map;
    }
}
