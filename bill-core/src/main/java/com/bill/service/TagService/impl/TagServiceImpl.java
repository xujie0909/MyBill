package com.bill.service.TagService.impl;

import com.bill.common.constant.ItemKeys;
import com.bill.common.utils.CacheUtils;
import com.bill.common.utils.RedisUtils;
import com.bill.dao.TagMapper;
import com.bill.pojo.Tag;
import com.bill.service.itemService.impl.ItemServiceImpl;
import com.bill.service.TagService.TagService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bill.common.constant.TagKeys.*;

@Service
public class TagServiceImpl implements TagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private TagMapper tagMapper;

    private RedisUtils redisUtils;


    /**
     * 获取高频标签
     *
     * @return
     */
    public List<String> getHighFrequencyTags() {

        List<Tag> allTags = tagMapper.getAllTags();

        if (allTags.size() < 1) {
            return null;
        }

        return allTags.stream()
                .map(c -> c.getTname())
                .collect(Collectors.toList());
    }

    /**
     * 将新标签存入数据库
     */
    public boolean saveTags(String TagNameStr) {

        if (StringUtils.isBlank(TagNameStr)) {
            return false;
        }

        for (String categoryName : TagNameStr.split(SPLIT)) {

            List<Tag> exiTags = tagMapper.getTagsByTname(categoryName);
            Tag exiTtag = exiTags.get(0);

            if (exiTtag == null){ //新标签
                tagMapper.addTag(new Tag(categoryName, FISTSCORE));
            }else{   //老标签
                exiTtag.setTcount(exiTtag.getTcount() + 1);
                tagMapper.updateTcount(exiTtag);
            }

                //新标签
                if (exiTags.size() < 1) {
                    tagMapper.addTag(new Tag(categoryName, FISTSCORE));
                    //RedisUtils.zAdd(ItemKeys.CategoryCount, categoryName, 1);
                    continue;
                }
        }
        return true;
    }
}
