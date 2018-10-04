package com.bill.web.controller;

import com.bill.pojo.StreamMoney;
import com.bill.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillService billService;



    @RequestMapping(value = "/bill",method = RequestMethod.GET)
    @ResponseBody
    public List<StreamMoney> getbill(){
        List<StreamMoney> all = billService.getBill();
        return all;
    }

    @RequestMapping(value = "/bill",method = RequestMethod.POST)
    public String addBill(StreamMoney  streamOfMoney) throws Exception{
        System.out.println(streamOfMoney);
        billService.addBill(streamOfMoney);
        return "index";
    }
}
