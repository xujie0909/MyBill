package com.bill.web.controller;

import com.bill.common.BillKeys;
import com.bill.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("{pageName}")
    public String toPage(@PathVariable String pageName, Model model) {
        if (BillKeys.PAGEINDEX.equals(pageName)) {
            return "index";
        }
        model.addAttribute("message","页面不对！");
        return"error";
    }
}

