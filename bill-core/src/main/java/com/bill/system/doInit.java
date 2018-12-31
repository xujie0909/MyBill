package com.bill.system;

import com.bill.common.utils.CacheUtils;
import com.bill.dao.TagMapper;
import com.bill.pojo.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.bill.common.constant.TagKeys.TAGCOUNT;

@Component
public class doInit implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(doInit.class);

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("初始化标签....");
        List<Tag> allTags = tagMapper.getAllTags();
        for (Tag tag : allTags) {
            CacheUtils.add(TAGCOUNT + tag.getTname(),tag.getTcount());
        }
        LOGGER.info("初始化标签完毕....");
    }
}
