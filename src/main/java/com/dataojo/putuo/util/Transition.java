package com.dataojo.putuo.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class Transition {
    public static String getPK(){
        String s1 = "mingzhu";
        long timestamp = System.currentTimeMillis();
        String s2 = String.valueOf(timestamp);
        String s3 = "dc77ef3d4b9d4b43be141fed4a8d182c";
        String result = s1 + s2 + s3;
        String res = getPublicKey(result);
//        System.out.println(timestamp);
//        System.out.println(res);
        return res;
    }
    public static String getPublicKey (String str) {
        String sortStr = sortStr( str);
        byte[] arr = DigestUtils.md5(sortStr);
        String hexString = bytesToHexString(arr);
        return hexString;
    }
    public static String sortStr(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);

    }
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString().toUpperCase();
    }
}
