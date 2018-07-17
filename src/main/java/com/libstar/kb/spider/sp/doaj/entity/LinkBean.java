package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author itguang
 * @create 2018-07-16 10:07
 **/
@Data
public class LinkBean {
    /**
     * url : http://ies.ijo.cn/cn_publish/2015/10/201510016.pdf
     * type : fulltext
     */

    @SerializedName("url")
    private String url;
    @SerializedName("type")
    private String type;
    @SerializedName("content_type")
    private String contentType;


}
