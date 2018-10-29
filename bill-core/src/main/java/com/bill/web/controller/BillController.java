package com.bill.web.controller;

import com.bill.pojo.StreamMoney;
import com.bill.service.billService.BillService;
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
@RequestMapping("/bill")
public class BillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/bill",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> getbill(){
        List<StreamMoney> all = billService.getBill();
        HashMap<String, Object> returnData = Maps.newHashMap();
        returnData.put("draw",1);
        returnData.put("recordsTotal",all.size());
        returnData.put("recordsFiltered",all.size());
        returnData.put("data",all);
        return returnData;
    }

    @RequestMapping(value = "/bill",method = RequestMethod.POST)
    public String addBill(StreamMoney  streamOfMoney) throws Exception{
        billService.addBill(streamOfMoney);
        return "index";
    }
}
