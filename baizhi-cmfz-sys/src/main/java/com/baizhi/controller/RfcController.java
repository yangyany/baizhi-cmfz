package com.baizhi.controller;

import com.baizhi.service.RfcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/15.
 */
@Controller
@RequestMapping("/rfc")
public class RfcController {
    @Resource
    private RfcService rfcService;

    /**
     * 分頁查所有
     */
    @RequestMapping("/queryAllRfcByPage")
    @ResponseBody
    public Map queryAllRfcByPage(Integer page, Integer rows){
        try {
            Map map = rfcService.queryRfcByPage(page, rows);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
