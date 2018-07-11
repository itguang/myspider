package com.libstar.kb.spider.sp.doaj.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author itguang
 * @create 2018-07-11 11:49
 **/
public class DoajUtil {

  public static  String baseUrl = "https://doaj.org/search?source={\"query\":{\"match_all\":{}},\"sort\":[{\"_score\":{\"order\":\"asc\"}}],\"from\":#,\"size\":10}";


    /**
     * 起始页数
     * @param start
     * @return
     */
    public static String getArticleUrl(String start){

        String url = baseUrl.replace("#", start);

        String encodeUrl = "";
        try {
            encodeUrl = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return encodeUrl;

    }


}
