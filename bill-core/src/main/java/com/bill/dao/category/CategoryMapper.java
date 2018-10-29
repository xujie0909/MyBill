package com.bill.dao.category;

import com.bill.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    //增加分类
    void addCategory(Category category);

    //更新频率
    void updateRate(Category category);

    //获取所有分类信息
    List<Category> getAllCateGory();

}
