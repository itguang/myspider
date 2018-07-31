package com.libstar.kb.spider.sp.blyun.util;

import us.codecraft.webmagic.Request;

import java.util.HashMap;

/**
 * @author 李增光
 * @create 2018-07-31 18:00
 **/
public class BlyunUtil {


    static String BASEURL = "http://fjour.blyun.com/magguide";
    static String KEY = "CB4DD1EC1F3C543293A0795282990F8D";
    static String UNITID = "33736";
    static String GO = "magsearch";
    static String JSON = "djson";
    static String X_REAL_IP = "106.15.229.61";
    /**
     * gjflids :按照挂接分类id号去查询当前分类下的期刊，暂时只支持单个分类查询。
     * choren 中外文
     * 两个参数配合使用
     */
   static String gjflids = "1";

    /**
     * 个人用户类型  正式用户：1    临时用户：0
     */
    static String usertype = "1";
    /**
     * 个人用户ID
     */
    static String userid = "1";
    /**
     * 检索词
     */
    static String keyword = "";
    /**
     * 页码
     */
    static String page = "1";

    //---------------------------------------------------
    /**
     * choren 中外文
     */
    static String choren = "1";
    /**
     * field不传的话，默认检索全部，field=1是检索标题
     */
    static String field = "";


    /**
     *
     * @param categoryId 分类id
     * @param p 页码,默认第一页
     * @return
     */
    public static Request getUrl(String categoryId, String p) {

        gjflids = categoryId;
        page = p;

        Request request = new Request();
        HashMap<String, String> map = new HashMap<>();

        map.put("unitid", UNITID);
        map.put("userid", userid);
        map.put("usertype", usertype);

        //设置cookie
        request.addCookie("msign", MD5Utils.md5("key=" + KEY + UrlUtils.sort(map)));
        //设置header
        request.addHeader("x-real-ip", X_REAL_IP);

        map.put("timestr", String.valueOf(System.currentTimeMillis()));
        map.put("go", GO);
        map.put("json", JSON);
        map.put("gjflids", gjflids);
//        map.put("choren", choren);
//        map.put("field", field);
        map.put("sw", keyword);
        map.put("page", page);

        map.put("enc", MD5Utils.md5(UrlUtils.sort(map) + KEY));

        //设置请求url
        request.setUrl(UrlUtils.appendParams(BASEURL, map));

        return request;

    }


}
