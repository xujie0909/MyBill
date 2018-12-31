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

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/itemDetail.do", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> getItems() {
        List<Item> all = itemService.getItems();
        if (all.size() == 0) {

            Item item = new Item();
            item.setIctime(new Date(System.currentTimeMillis()));
            item.setImoney(new BigDecimal(0));
            item.setIname("暂无");
            item.setInOut("暂无");
            item.setTags("暂无");
            item.setItype("暂无");
            all.add(item);
        }
        HashMap<String, Object> returnData = Maps.newHashMap();
        returnData.put("draw", 1);
        returnData.put("recordsTotal", all.size());
        returnData.put("recordsFiltered", all.size());
        returnData.put("data", all);
        LOGGER.info("return data is {}", returnData);

        return returnData;
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String addBill(Item item) throws Exception {
        if (item == null) {
            return "error";
        }
        itemService.addItem(item);
        return "index";
    }
}
