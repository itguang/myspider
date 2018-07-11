package com.libstar.kb.spider.sp.cspd.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author itguang
 * @create 2018-07-02 11:29
 **/
public class UrlUtils {


    /**
     * 向url链接追加参数
     *
     * @param url
     * @param params Map<String, String>
     * @return
     */
    public static String appendParams(String url, Map<String, String> params) {
        if (StrUtils.isBlank(url)) {
            return "";
        } else if (StrUtils.isEmptyMap(params)) {
            return url.trim();
        } else {
            StringBuffer sb = new StringBuffer("");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);

            url = url.trim();
            int length = url.length();
            int index = url.indexOf("?");
            if (index > -1) {//url说明有问号
                if ((length - 1) == index) {//url最后一个符号为？，如：http://wwww.baidu.com?
                    url += sb.toString();
                } else {//情况为：http://wwww.baidu.com?aa=11
                    url += "&" + sb.toString();
                }
            } else {//url后面没有问号，如：http://wwww.baidu.com
                url += "?" + sb.toString();
            }
            return url;
        }
    }

    /**
     * 向url链接追加参数(单个)
     *
     * @param url
     * @param name  String
     * @param value String
     * @return
     */
    public static String appendParam(String url, String name, String value) {
        if (StrUtils.isBlank(url)) {
            return "";
        } else if (StrUtils.isBlank(name)) {
            return url.trim();
        } else {
            Map<String, String> params = new HashMap<String, String>();
            params.put(name, value);
            return appendParams(url, params);
        }
    }

    /**
     * 移除url链接的多个参数
     *
     * @param url        String
     * @param paramNames String[]
     * @return
     */
    public static String removeParams(String url, String... paramNames) {
        if (StrUtils.isBlank(url)) {
            return "";
        } else if (StrUtils.isEmptyArray(paramNames)) {
            return url.trim();
        } else {
            url = url.trim();
            int length = url.length();
            int index = url.indexOf("?");
            if (index > -1) {//url说明有问号
                if ((length - 1) == index) {//url最后一个符号为？，如：http://wwww.baidu.com?
                    return url;
                } else {//情况为：http://wwww.baidu.com?aa=11或http://wwww.baidu.com?aa=或http://wwww.baidu.com?aa
                    String baseUrl = url.substring(0, index);
                    String paramsString = url.substring(index + 1);
                    String[] params = paramsString.split("&");
                    if (!StrUtils.isEmptyArray(params)) {
                        Map<String, String> paramsMap = new HashMap<String, String>();
                        for (String param : params) {
                            if (!StrUtils.isBlank(param)) {
                                String[] oneParam = param.split("=");
                                String paramName = oneParam[0];
                                int count = 0;
                                for (int i = 0; i < paramNames.length; i++) {
                                    if (paramNames[i].equals(paramName)) {
                                        break;
                                    }
                                    count++;
                                }
                                if (count == paramNames.length) {
                                    paramsMap.put(paramName, (oneParam.length > 1) ? oneParam[1] : "");
                                }
                            }
                        }
                        if (!StrUtils.isEmptyMap(paramsMap)) {
                            StringBuffer paramBuffer = new StringBuffer(baseUrl);
                            paramBuffer.append("?");
                            Set<String> set = paramsMap.keySet();
                            for (String paramName : set) {
                                paramBuffer.append(paramName).append("=").append(paramsMap.get(paramName)).append("&");
                            }
                            paramBuffer.deleteCharAt(paramBuffer.length() - 1);
                            return paramBuffer.toString();
                        }
                        return baseUrl;
                    }
                }
            }
            return url;
        }
    }


    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     * @param URL  url地址
     * @return  url请求参数部分
     */
    public static Map<String, String> getParams(String URL)
    {
        Map<String, String> mapRequest = new HashMap<String, String>();

        String[] arrSplit=null;

        String strUrlParam=getParamsFormUrl(URL);
        if(strUrlParam==null)
        {
            return mapRequest;
        }
        //每个键值为一组 www.2cto.com
        arrSplit=strUrlParam.split("[&]");
        for(String strSplit:arrSplit)
        {
            String[] arrSplitEqual=null;
            arrSplitEqual= strSplit.split("[=]");

            //解析出键值
            if(arrSplitEqual.length>1)
            {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            }
            else
            {
                if(arrSplitEqual[0]!="")
                {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    /**
     * 去掉url中的路径，留下请求参数部分
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String getParamsFormUrl(String strURL)
    {
        String strAllParam=null;
        String[] arrSplit=null;

        strURL=strURL.trim().toLowerCase();

        arrSplit=strURL.split("[?]");
        if(strURL.length()>1)
        {
            if(arrSplit.length>1)
            {
                if(arrSplit[1]!=null)
                {
                    strAllParam=arrSplit[1];
                }
            }
        }

        return strAllParam;
    }

}
