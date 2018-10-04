package com.bill.dao.streamMoney;


import java.util.List;

public interface StreamMoneyMapper {

    List<com.bill.pojo.StreamMoney> getBill();

    void addBill(com.bill.pojo.StreamMoney streamOfMoney);


}
