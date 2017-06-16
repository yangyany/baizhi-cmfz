package com.baizhi.service.impl;

import com.baizhi.dao.AccordionDAO;
import com.baizhi.entity.Accordion;
import com.baizhi.service.AccordionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yanyan on 2017/6/11.
 */
@Service("accordionService")
@Transactional
public class AccordionServiceImpl implements AccordionService {

    @Autowired
    private AccordionDAO accordionDAO;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Accordion> queryAll() {

        return accordionDAO.selectAll();
    }
}
