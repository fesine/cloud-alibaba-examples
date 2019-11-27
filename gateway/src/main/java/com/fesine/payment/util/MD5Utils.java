package com.fesine.payment.util;

import java.security.MessageDigest;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2019/11/27
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/11/27
 */
public class MD5Utils {
    private static final String MD5 = "MD5";
    private static final String DEFAULT_ENCODING = "UTF-8";

    public final static String MD5(String source, String encoding) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
                'E', 'F'};
        try {
            byte[] btInput = source.getBytes(encoding);
            MessageDigest mdInst = MessageDigest.getInstance(MD5);
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final static String MD5(String source) {
        return MD5(source, DEFAULT_ENCODING);
    }
}
