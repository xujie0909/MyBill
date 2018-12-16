package com.bill.service.initService.impl;

import com.bill.common.utils.CacheUtils;
import com.bill.dao.TagMapper;
import com.bill.pojo.Tag;
import com.bill.service.initService.RedisInit;
import com.bill.web.controller.ItemController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RedisInitImpl implements RedisInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void categoryInit() {

        LOGGER.info("初始化标签....");
        List<Tag> allTags = tagMapper.getAllTags();
        for (Tag tag : allTags) {
            CacheUtils.add(tag.getTname(),tag.getTcount());
        }
        LOGGER.info("初始化标签完毕....");
    }
}
