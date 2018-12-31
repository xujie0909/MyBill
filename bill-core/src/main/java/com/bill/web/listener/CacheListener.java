package com.bill.web.listener;

import com.bill.common.utils.CacheUtils;
import com.bill.dao.TagMapper;
import com.bill.pojo.Tag;
import com.bill.system.doInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

import static com.bill.common.constant.TagKeys.TAGCOUNT;


public class CacheListener implements ServletContextListener{

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        LOGGER.info("初始化标签....");
//        List<Tag> allTags = tagMapper.getAllTags();
//        for (Tag tag : allTags) {
//            CacheUtils.add(TAGCOUNT + tag.getTname(),tag.getTcount());
//        }
//        LOGGER.info("初始化标签完毕....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
