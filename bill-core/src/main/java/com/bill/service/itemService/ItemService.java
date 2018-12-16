package com.bill.service.itemService;

import com.bill.pojo.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    boolean addItem(Item item);



}
