package com.libstar.kb.spider.sp.doab;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static Integer getPage(String pages){

        if(null==pages){
            return null;
        }

        String regex = "([1-9]\\d*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pages);
        if(m.find()){
            int i = Integer.parseInt( m.group());
            return i;
        }
        return null;
    }


}
