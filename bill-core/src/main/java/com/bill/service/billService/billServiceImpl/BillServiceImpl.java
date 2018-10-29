package com.bill.service.billService.billServiceImpl;

import com.bill.common.BillKeys;
import com.bill.common.utils.Base64Utils;
import com.bill.common.utils.RedisUtils;
import com.bill.common.utils.UuidUtils;
import com.bill.dao.category.CategoryMapper;
import com.bill.dao.streamMoney.StreamMoneyMapper;
import com.bill.pojo.Category;
import com.bill.pojo.StreamMoney;
import com.bill.service.billService.BillService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceImpl.class);

    @Autowired
    private StreamMoneyMapper streamOfMoneyMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<com.bill.pojo.StreamMoney> getBill() {
        List<com.bill.pojo.StreamMoney> bills = streamOfMoneyMapper.getBill();
        return bills;
    }

    @Transactional
    @Override
    public void addBill(StreamMoney streamMoney) throws Exception {

        //获取分类标签，支持多标签
        String[] categorys = streamMoney.getCategory().split("；");

        //记录处理每一个标签
        for (String category : categorys) {
            //获取category_code
            String categoryEncode = Base64Utils.encode(category);
            if (RedisUtils.zScore(BillKeys.CategoryCount, categoryEncode) == null) { //新标签
                categoryMapper.addCategory(new Category(UuidUtils.getUuid(), categoryEncode, category, streamMoney.getInOutFlag(), "1"));
                //计数器+1
                RedisUtils.zAdd(BillKeys.CategoryCount, categoryEncode, 1);
            } else { // 老标签
                //计数器+1
                RedisUtils.incrementScore(BillKeys.CategoryCount, categoryEncode, 1);
                //更新到数据库
                Category updateCategory = new Category();
                Double aDouble = RedisUtils.zScore(BillKeys.CategoryCount, category);

                updateCategory.setRate(RedisUtils.zScore(BillKeys.CategoryCount, categoryEncode) + "");
                updateCategory.setCategoryCode(categoryEncode);
                categoryMapper.updateRate(updateCategory);
            }
        }

        //如果是新增，需要设置id和创建时间
        if (streamMoney.getFlag().equals("0")) {
            //创建时间
            streamMoney.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            //id
            if (StringUtils.isNotBlank(streamMoney.getInOutFlag())
                    && BillKeys.IN.equals(streamMoney.getInOutFlag())) {
                streamMoney.setId(BillKeys.INPREFIX + System.currentTimeMillis());
            } else if (StringUtils.isNotBlank(streamMoney.getInOutFlag())
                    && BillKeys.Out.equals(streamMoney.getInOutFlag())) {
                streamMoney.setId(BillKeys.OUTPREFIX + System.currentTimeMillis());
            } else {
                streamMoney.setId(BillKeys.OTHERPREFIX + System.currentTimeMillis());
            }
            streamOfMoneyMapper.addBill(streamMoney);
        }else if(streamMoney.getFlag().equals("1")){
            streamOfMoneyMapper.updateBill(streamMoney);
        }
    }
}
