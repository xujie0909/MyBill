package com.bill.service.categoryService.categoryServiceImpl;

import com.bill.common.BillKeys;
import com.bill.common.utils.Base64Utils;
import com.bill.common.utils.RedisUtils;
import com.bill.dao.category.CategoryMapper;
import com.bill.pojo.Category;
import com.bill.service.billService.billServiceImpl.BillServiceImpl;
import com.bill.service.categoryService.CategoryService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    private RedisUtils redisUtils;

    /**
     * 获取高频分类
     * @return
     */
    public List<String> getHighFrequencyCategory() {
        Set<Object> categoryResults = redisUtils.zrevrangebyscore(BillKeys.CategoryCount, 0d, 100d);
        ArrayList<String> categoryLists = Lists.newArrayList();
        if(categoryResults != null && categoryResults.size() > 0){
            for (Object o: categoryResults) {
                String categoryName = (String)o;
                try {
                    categoryLists.add(Base64Utils.decode(categoryName));
                } catch (Exception e) {
                    LOGGER.info("getHighFrequencyCategory occured a error!!");
                }
            }
        }else{
            List<Category> allCateGory = categoryMapper.getAllCateGory();
            for (Category category:allCateGory ) {
                redisUtils.zAdd(BillKeys.CategoryCount, category.getCategoryCode(),Double.parseDouble(category.getRate()));
                categoryLists.add(category.getCategoryName());
            }
        }
        return categoryLists;
    }

}
