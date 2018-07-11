package com.libstar.kb.spider.sp.datadryad.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author itguang
 * @create 2018-07-09 16:46
 **/
public class DryadUtil {


    /**
     * 获取 https://datadryad.org/resource/doi:10.5061/dryad.vt536 的 vt536
     * @param contentUrl 如: https://datadryad.org/resource/doi:10.5061/dryad.vt536
     * @return
     */
    public static String getId(String contentUrl){

        if (contentUrl!=null){

            int i = contentUrl.lastIndexOf(".");
            return contentUrl.substring(i+1);

        }
        return null;
    }

    /**
     * 获取指定HTML标签的指定属性的值
     * @param source 要匹配的源文本
     * @param element 标签名称
     * @param attr 标签的属性名称
     * @return 属性值列表
     */
    public static List<String> match(String source, String element, String attr) {
        List<String> result = new ArrayList<String>();
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result;

    }

    /**
     *
     * @param html
     * @return
     */
    public static Map<String,String> getMap(String html){

        Document document = Jsoup.parse(html);

        Elements tds = document.select("td");

        ArrayList<String> scientificName = new ArrayList<>();

        for (Element element : tds) {

            String text = element.text();

            if (!"".equals(text)) {
                scientificName.add(text);
            }


        }


        String[] array = new String[scientificName.size()];
        scientificName.toArray(array);


        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < array.length-1; i++) {

            if (map.get(array[i]) == null) {
                map.put(array[i], array[++i]);
            } else {
                map.put(array[i], map.get(array[i]) + "," + array[++i]);
            }

        }

        return map;

    }




}
