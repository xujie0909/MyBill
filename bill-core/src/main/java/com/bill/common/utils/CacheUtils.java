package com.bill.common.utils;

import java.util.HashMap;

public class CacheUtils {

    private static final int initCountValue = 1;
    private static HashMap<String, Object> cacheMap = new HashMap<>();

    //增
    public static boolean add(String key,Object value){
        cacheMap.put(key, value);
        return true;
    }

    //查
    public static Object get(String key){
        return cacheMap.get(key);
    }

    //增加计数
    public static boolean incrCount(String key) {

        if (cacheMap.get(key) == null) {
            cacheMap.put(key, initCountValue);
            return true;
        }

        try {
            cacheMap.put(key, (Long) cacheMap.get(key) + 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
