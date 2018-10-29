package com.bill.dao.streamMoney;


import com.bill.pojo.StreamMoney;

import java.util.List;

public interface StreamMoneyMapper {

    List<com.bill.pojo.StreamMoney> getBill();

    void addBill(com.bill.pojo.StreamMoney streamOfMoney);

    void updateBill(StreamMoney streamMoney);
}
