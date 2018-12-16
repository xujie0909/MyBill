package com.bill.service.itemService.impl;

import com.bill.dao.TagMapper;
import com.bill.dao.ItemMapper;
import com.bill.pojo.Item;
import com.bill.service.itemService.ItemService;
import com.bill.service.TagService.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private TagService tagService;


    @Override
    public List<Item> getItems() {
        List<Item> items = itemMapper.getItems();
        return items;
    }

    @Transactional
    @Override
    public boolean addItem(Item item){

        //处理标签
        boolean isSus = tagService.saveTags(item.getTags());
        if(!isSus){
            return false;
        }

        itemMapper.addItem(item);
        return true;
    }
}
