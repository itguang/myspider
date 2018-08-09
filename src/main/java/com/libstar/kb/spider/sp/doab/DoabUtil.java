package com.libstar.kb.spider.sp.doab;

import java.util.Arrays;

/**
 * @author 李增光
 * @create 2018-08-09 17:14
 **/
public class DoabUtil {


    public static char[] initArray() {

        char[] arrays = new char[26];

        for (int i = 0; i < 26; i++) {
            arrays[i] = (char) (65 + i);
        }
        return arrays;


    }


}
