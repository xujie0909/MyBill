package com.bill.system;

import com.bill.common.BillKeys;
import com.bill.common.utils.RedisUtils;
import com.bill.dao.category.CategoryMapper;
import com.bill.pojo.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class doInit implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(doInit.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("======================开始加载redis 分类表......");
        if(RedisUtils.zScard(BillKeys.CategoryCount) == 0){
            List<Category> allCateGorys = categoryMapper.getAllCateGory();
            for (Category cgy:allCateGorys) {
                RedisUtils.zAdd(BillKeys.CategoryCount,cgy.getCategoryCode(),Double.parseDouble(cgy.getRate()));
            }
        }
        LOGGER.info("======================加载redis 分类表完毕！");
    }
}
