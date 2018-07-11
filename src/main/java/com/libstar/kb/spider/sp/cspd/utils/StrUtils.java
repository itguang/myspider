package com.libstar.kb.spider.sp.cspd.utils;

import java.util.Map;

/**
 * @author itguang
 * @create 2018-07-02 11:30
 **/
public class StrUtils {


    /**
     * 判断Map是否为空
     * @param map
     * @return
     */
    public static <K, V> boolean isEmptyMap(Map<K, V> map) {
        return (map == null || map.size() < 1);
    }

    /**
     * 判断数组是否为空
     * @param obj
     * @return
     */
    public static boolean isEmptyArray(Object[] obj) {
        return (obj == null || obj.length < 1);
    }



    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

}
