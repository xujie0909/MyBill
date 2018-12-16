package com.bill.web.controller;

import com.bill.service.TagService.TagService;
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

@RequestMapping("/tag")
@Controller
public class TagController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/highFrequencyTag", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getHighFrequencyTag() {
        List<String> highFrequencyCategory = null;
        highFrequencyCategory = tagService.getHighFrequencyTags();

        if (highFrequencyCategory == null) {
            ArrayList<String> returnList = Lists.newArrayList();
            returnList.add("啥也木有");
            return returnList;
        }
        return highFrequencyCategory;
    }
}
