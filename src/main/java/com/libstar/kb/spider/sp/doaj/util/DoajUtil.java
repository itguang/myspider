package com.libstar.kb.spider.sp.doaj.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author itguang
 * @create 2018-07-11 11:49
 **/
public class DoajUtil {

    /**
     *https://doaj.org/query/journal,article/_search?source={%22query%22:{%22match_all%22:{}},%22from%22:20,%22size%22:10}
     * https://doaj.org/query/journal,article/_search?source={"query":{"match_all":{}},"from":20,"size":10}
     * }
     *///jQuery19104550269291196112_1533693037955
      // jQuery19104550269291196112_1533693037955
    //https://doaj.org/query/journal,article/_search?ref=doaj&callback=jQuery19104550269291196112_1533693037955&source={ "query": { "match_all": {} }, "from": 0, "size": 10 }
    public static String baseUrl = "https://doaj.org/query/journal,article/_search?ref=doaj&callback=jQuery19104550269291196112_1533693037955&source=";

    public static String params = "{\"query\":{\"match_all\":{}},\"from\":#,\"size\":20}";
//    public static String params = "{ \"query\": { \"match_all\": {} },\"from\": #, \"size\": 10 }";

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

    /**
     *
     * @param url
     * @return
     */
    public static int getFrom(String url){

        String decode="";
        try {
             decode = URLDecoder.decode(url, "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int i = decode.lastIndexOf("=");
        String source = decode.substring(i + 1, decode.length());

        JsonObject parse = new JsonParser().parse(source).getAsJsonObject();

        int from = parse.get("from").getAsInt();

        return from;
    }


}



