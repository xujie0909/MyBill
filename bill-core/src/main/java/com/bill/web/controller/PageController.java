package com.bill.web.controller;

import com.bill.common.constant.ItemKeys;
import com.bill.service.TagService.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private TagService tagService;

    @RequestMapping("{pageName}")
    public String toPage(@PathVariable String pageName, Model model) {

        //主页
        if (ItemKeys.PAGEINDEX.equals(pageName)) {
            List<String> hotTags = tagService.getHighFrequencyTags();
            model.addAttribute("hotTags",hotTags);
            return "index";
        }

        //未选择页面
        model.addAttribute("message","页面不对！");
        return"error";
    }
}

