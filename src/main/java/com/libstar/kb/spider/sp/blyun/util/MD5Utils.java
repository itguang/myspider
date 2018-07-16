package com.libstar.kb.spider.sp.blyun.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * @author itguang
 */
@Slf4j
public class MD5Utils {


    static String BASEURL = "http://fjour.blyun.com/magguide";

    static String key = "CA8768191C13390AC8CA476A87D97A6E";

    /**
     * 使用md5的算法进行加密
     */
    public static String md5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
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

    public static void main(String[] agrs) {

       HashMap<String, String> map = new HashMap<>();

        //机构id
        map.put("unitid ", "309");

        //个人用户ID
        map.put("userid", "1");

        //个人用户类型  正式用户：1    临时用户：0
        map.put("usertype", "0");

        //字典顺序排序
        String cookie = UrlUtils.sort(map);
        String msign = MD5Utils.md5("key="+key + cookie);

        //设置header

        log.info("x-real-ip={}","49.74.43.232");
        //设置cookie

        log.info("msign={}",msign);



        map.put("field","1");
//        map.put("page", "1");

        map.put("go", "magsearch");
        //检索词
        map.put("sw", "教育");

        map.put("json", "djson");


        //毫秒级系统时间
        map.put("timestr", String.valueOf(System.currentTimeMillis()));

        //字典顺序排序
        String sort = UrlUtils.sort(map);
        //MD5 加密
        String md5 = MD5Utils.md5(sort + key);

        //用户验证加密串
        map.put("enc", md5);

        //拼接url
        String requestUrl = UrlUtils.appendParams(BASEURL, map);
        log.info("requestUrl={}",requestUrl);

    }


}
