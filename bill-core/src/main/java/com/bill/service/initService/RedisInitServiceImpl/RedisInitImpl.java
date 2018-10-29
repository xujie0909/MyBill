package com.bill.service.initService.RedisInitServiceImpl;

import com.bill.common.BillKeys;
import com.bill.common.utils.RedisUtils;
import com.bill.dao.category.CategoryMapper;
import com.bill.pojo.Category;
import com.bill.service.initService.RedisInit;
import com.bill.web.controller.BillController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RedisInitImpl implements RedisInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void categoryInit() {
        LOGGER.info("=====================开始加载redis分类表......");
        //如果服务重启，category的缓存redis为空，第一次查询，加载所有字典，后期优化
        Long l = RedisUtils.zScard(BillKeys.CategoryCount);
        System.out.println(l);
        if(RedisUtils.zScard(BillKeys.CategoryCount) == 0){
            List<Category> allCateGorys = categoryMapper.getAllCateGory();
            for (Category cgy:allCateGorys) {
                RedisUtils.zAdd(BillKeys.CategoryCount,cgy.getCategoryCode(),Double.parseDouble(cgy.getRate()));
            }
        }
        LOGGER.info("=====================redis分类表加载完毕......");
    }
}
