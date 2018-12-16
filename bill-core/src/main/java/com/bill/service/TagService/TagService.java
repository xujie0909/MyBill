package com.bill.service.TagService;

import java.util.List;

public interface TagService {
    //获取高频分类
    List<String> getHighFrequencyTags();

    //将新标签存入数据库
    boolean saveTags(String TagNameStr);
}
