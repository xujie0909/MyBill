package com.bill.web.controller;

import com.bill.pojo.Item;
import com.bill.service.itemService.ItemService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> getItems(){
        List<Item> all = itemService.getItems();
        HashMap<String, Object> returnData = Maps.newHashMap();
        returnData.put("draw",1);
        returnData.put("recordsTotal",all.size());
        returnData.put("recordsFiltered",all.size());
        returnData.put("data",all);
        return returnData;
    }

    @RequestMapping(value = "/item",method = RequestMethod.POST)
    public String addBill(Item item) throws Exception{
        if(item == null){
            return "error";
        }
        itemService.addItem(item);
        return "index";
    }
}
