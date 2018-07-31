package com.libstar.kb.spider.sp.blyun.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 李增光
 * @create 2018-07-31 17:46
 **/
@Data
@Entity
public class BlyunArticleEntity {

    /**
     * cn :
     * coverurl : http://unicover.blyun.com/coverNew/CoverNew.dll?iid=6C6B697168696969706F686E6E6C5F9BA5B2AEA75F6A3137313735333039
     * currentstate :
     * cxkey : 3caf786d1e1dc6839830191c1b4bc100
     * cycle :
     * d : E074F839B2EAC42B90CE98A46853E681
     * fenlei : ;13;
     * fenleiname : 综合&nbsp&nbsp
     * issn : 2161-4881
     * language :
     * magid : 320800076553
     * magname : Journal of Surface Engineered Materials and Advanced Technology
     * record :
     * summary :
     * unit : 美国科研出版社
     * url : http://fjour.blyun.com/magguide?go=maginfo&magid=320800076553
     * years : 2011
     */



    @Id
    @SerializedName("magid")
    private String magid;

    @SerializedName("cn")
    private String cn;
    @SerializedName("coverurl")
    private String coverurl;
    @SerializedName("currentstate")
    private String currentstate;
    @SerializedName("cxkey")
    private String cxkey;
    @SerializedName("cycle")
    private String cycle;
    @SerializedName("d")
    private String d;
    @SerializedName("fenlei")
    private String fenlei;
    @SerializedName("fenleiname")
    private String fenleiname;
    @SerializedName("issn")
    private String issn;
    @SerializedName("language")
    private String language;

    @SerializedName("magname")
    private String magname;
    @SerializedName("record")
    private String record;
    @SerializedName("summary")
    private String summary;
    @SerializedName("unit")
    private String unit;
    @SerializedName("url")
    private String url;
    @SerializedName("years")
    private String years;


}
