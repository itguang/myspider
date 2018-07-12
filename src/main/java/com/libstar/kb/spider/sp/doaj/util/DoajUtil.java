package com.libstar.kb.spider.sp.doaj.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author itguang
 * @create 2018-07-11 11:49
 **/
public class DoajUtil {

    /**
     * https://doaj.org/query/journal,article/_search?&callback=jQuery191028819401622742236_1531308284755&source={
     * "query": {
     * "match_all": {}
     * },
     * "from": 0,
     * "size": 10
     * }
     */

    public static String baseUrl = "https://doaj.org/query/journal,article/_search";

    public static String params = "&callback=jQuery191028819401622742236_1531308284755&source={ \"query\": { \"match_all\": {} }, \"from\": #, \"size\": 10 }";

    /**
     *
     *
     * @param start 起始位置from
     * @return
     */
    public static String getArticleUrl(String start) {

        String params2 = params.replace("#", start);
        String encode = "";
        try {
            encode = URLEncoder.encode(params2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url = baseUrl + encode;


        return url;

    }


}



