package com.baizhi.test;

import com.baizhi.entity.Accordion;
import com.baizhi.service.AccordionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yanyan on 2017/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestAccordion {
    @Autowired
    private AccordionService accordionService;

    @Test
    public void testSelectAll() {
        List<Accordion> accordions = accordionService.queryAll();
        for (Accordion accordion : accordions) {
            System.out.println(accordion);
            List<Accordion> children = accordion.getChildren();
            System.out.println(children.size());
            for (Accordion child : children) {
                System.out.println(child);

            }
        }
    }

}
