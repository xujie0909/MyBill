package com.bill.dao;

import com.bill.pojo.Tag;

import java.util.List;

public interface TagMapper {

    //增加分类
    void addTag(Tag tag);

    //根据标签名称更新计数
    void updateTcount(Tag tag);

    //获取所有分类信息
    List<Tag> getAllTags();
    //根据标签名称查询标签
    List<Tag> getTagsByTname(String tname);


}
