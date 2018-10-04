package com.bill.service;

import com.bill.pojo.Category;

import java.util.List;

public interface CategoryService {
    //获取高频分类
    List<String> getHighFrequencyCategory() throws Exception;
}
