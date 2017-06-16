package com.baizhi.controller;

import com.baizhi.entity.Accordion;
import com.baizhi.service.AccordionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanyan on 2017/6/11.
 */
@Controller
@RequestMapping("/accordion")
public class AccordionController {

    @Resource
    private AccordionService accordionService;

    /**
     * 展示所有
     */
    @RequestMapping("/queryAllAccordion")
    @ResponseBody
    public List<Accordion> queryAllAccordion(){
        List<Accordion> accordions = accordionService.queryAll();
        return accordions;
    }
}
