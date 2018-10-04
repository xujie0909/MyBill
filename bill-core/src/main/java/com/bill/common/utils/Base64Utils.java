package com.bill.common.utils;

import java.util.Base64;

public class Base64Utils {

    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();

    //加密
    public static String encode(String str) throws Exception{
        return encoder.encodeToString(str.getBytes("UTF-8"));
    }

    //解密
    public static String decode(String str ) throws Exception {
        return new String(decoder.decode(str), "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
        //解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));

        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text1 = "字串文字";
        final byte[] textByte1 = text.getBytes("UTF-8");
        //编码
        final String encodedText1 = encoder.encodeToString(textByte);
        System.out.println(encodedText1);
        //解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }




}
