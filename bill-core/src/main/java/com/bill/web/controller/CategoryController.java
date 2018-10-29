package com.bill.web.controller;

import com.bill.service.categoryService.CategoryService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/category")
@Controller
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/highFrequencyCategory",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getHighFrequencyCategory() {
        List<String> highFrequencyCategory = null;
        try {
            highFrequencyCategory = categoryService.getHighFrequencyCategory();
        } catch (Exception e) {
            LOGGER.info("getHighFrequencyCategory occured a error!");
        }
        if(highFrequencyCategory == null){
            ArrayList<String> returnList = Lists.newArrayList();
            returnList.add("啥也木有");
            return returnList;
        }
        return highFrequencyCategory;
    }
}
