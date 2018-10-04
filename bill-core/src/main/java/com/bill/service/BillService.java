package com.bill.service;

import com.bill.pojo.StreamMoney;

import java.util.List;

public interface BillService {

    List<StreamMoney> getBill();

    void addBill(StreamMoney streamOfMoney) throws Exception;



}
