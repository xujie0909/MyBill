package com.bill.dao;


import com.bill.pojo.Item;

import java.util.List;

public interface ItemMapper {

    List<Item> getItems();

    void addItem(Item item);

    void updateItem(Item item);
}
