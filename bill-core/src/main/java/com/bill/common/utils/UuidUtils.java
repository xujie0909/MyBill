package com.bill.common.utils;

import java.util.UUID;

public class UuidUtils {

    //获取uuid
    public static String getUuid(){
        String[] idd=UUID.randomUUID().toString().split("-");
        return idd[0]+idd[1]+idd[2];
    }
}
