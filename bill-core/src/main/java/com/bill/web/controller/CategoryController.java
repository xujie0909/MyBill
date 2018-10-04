package com.bill.web.controller;

import com.bill.pojo.Category;
import com.bill.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/category")
@Controller
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/highFrequencyCategory")
    @ResponseBody
    public List<String> getHighFrequencyCategory() {
        List<String> highFrequencyCategory = null;
        try {
            highFrequencyCategory = categoryService.getHighFrequencyCategory();
        } catch (Exception e) {
            LOGGER.info("getHighFrequencyCategory occured a error!");
        }
        return highFrequencyCategory;
    }
}
