package com.libstar.kb.spider.sp.cspd.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 期刊杂志 实体类,(比如时代周刊)
 * @author itguang
 * @create 2018-06-26 15:57
 **/


@Data
@Entity
public class ArticleEntity {


    /**
     * id : periodicalinfo_kfjyyj
     * proprieter : 张德明
     * avg_perio_down : 478.15
     * former_name : 文科月刊(1982-1995)
     * perio_id : kfjyyj
     * language : chi
     * major_editor : 徐皓
     * start_year02 : 378662400000
     * issue_postcode : 4-578
     * perio_format : A4
     * fax : 8621-65631403
     * share_num : 0
     * classcode_level : G4
     * publish_cycle : 双月刊
     * pinyin_title : Kai Fang Jiao Yu Yan Jiu
     * avg_article_down : 23.1
     * hostunit_name : ["上海远程教育集团","上海开放大学"]
     * director : 希建华
     * postcode : 200086
     * main_column : ["高阶访谈","理论探讨","发展战略","国际交流","研究报告","技术支撑"]
     * telephone : 8621-25653938
     * cite_num : 10848
     * perio_title02 : 开放教育研究
     * country_code : 31
     * issn : 1007-2179
     * data_state : add
     * ef_name : 《开放教育研究》编辑部
     * release_cycle : 双月刊
     * end_issue : null
     * start_year : 1982
     * core_perio : ["CSTPCD","CSSCI","北大核心"]
     * tag_num : 0
     * abstract_reading_num : 0
     * hostunit_area : 上海市
     * thirdparty_links_num : 0
     * import_num : 0
     * email : kfjy@shtvu.edu.cn
     * website : http://opendeu.shtvu.edu.cn
     * address : 上海市大连路1541号教视大厦1301室
     * source_db : WF
     * cn : 31-1724/G4
     * collection_num : 0
     * dep_name : 上海市教育委员会
     * download_num : 153017
     * first_publish : 0
     * affectoi : 9.8439998626709
     * article_num : 1975
     * fulltext_reading_num : 0
     * note_num : 0
     * win_prize : ["华东地区社会科学类优秀期刊提名奖（99）","中文社会科学引文索引（CSSCI）来源期刊"]
     * end_year : 1514736000000
     * class_code : G4
     * trans_title : Education Research  개방육구
     * perio_title : 开放教育研究
     * perio_desc : 本刊是中国远程教育期刊领域唯一一本，也是第一本进入CSSCI来源期刊的国家级学术刊物。《开放教育研究》集中了国内外开放与远程教育领域的一流专家，组成了一支高水平，强阵容的顾问委员会和专家委员会，立足于远程教育，以开放的理念包容学派，以创新的思想总结理论，以务实的态度关注实践。
     * keywords : null
     * summary :
     * class_type : periodical_info
     */

    @Id
    @SerializedName("id")
    private String id;


    //
    @SerializedName("proprieter")
    private String proprieter;


    @SerializedName("avg_perio_down")
    private double avgPerioDown;

    //
    @SerializedName("former_name")
    private String formerName;
    @SerializedName("perio_id")
    //
    private String perioId;
    @SerializedName("language")
    //
    private String language;
    @SerializedName("major_editor")
    //
    private String majorEditor;
    @SerializedName("start_year02")
    private long startYear02;
    @SerializedName("issue_postcode")
    //
    private String issuePostcode;
    @SerializedName("perio_format")
    //
    private String perioFormat;
    @SerializedName("fax")
    //
    private String fax;
    @SerializedName("share_num")
    private int shareNum;

    @SerializedName("publish_cycle")
    //
    private String publishCycle;
    @SerializedName("pinyin_title")
    //
    private String pinyinTitle;
    @SerializedName("avg_article_down")
    private double avgArticleDown;
    @SerializedName("director")
    //
    private String director;
    @SerializedName("postcode")
    //
    private String postcode;
    @SerializedName("telephone")
    //
    private String telephone;
    @SerializedName("cite_num")
    private int citeNum;
    @SerializedName("perio_title02")
    //
    private String perioTitle02;
    @SerializedName("country_code")
    //
    private String countryCode;
    @SerializedName("issn")
    //
    private String issn;
    @SerializedName("data_state")
    //
    private String dataState;
    @SerializedName("ef_name")
    //
    private String efName;
    @SerializedName("release_cycle")
    //
    private String releaseCycle;
    @SerializedName("end_issue")
    //
    private String endIssue;
    @SerializedName("start_year")
    //
    private String startYear;
    @SerializedName("tag_num")
    private int tagNum;
    @SerializedName("abstract_reading_num")
    private int abstractReadingNum;
    @SerializedName("hostunit_area")
    //
    private String hostunitArea;
    @SerializedName("thirdparty_links_num")
    private int thirdpartyLinksNum;
    @SerializedName("import_num")
    private int importNum;
    @SerializedName("email")
    //
    private String email;
    @SerializedName("website")
    //
    private String website;
    @SerializedName("address")
    //
    private String address;
    @SerializedName("source_db")
    //
    private String sourceDb;
    @SerializedName("cn")
    //
    private String cn;
    @SerializedName("collection_num")
    private int collectionNum;
    @SerializedName("dep_name")
    //
    private String depName;
    @SerializedName("download_num")
    private int downloadNum;
    @SerializedName("first_publish")
    //
    private String firstPublish;
    @SerializedName("affectoi")
    private double affectoi;
    @SerializedName("article_num")
    private int articleNum;
    @SerializedName("fulltext_reading_num")
    private int fulltextReadingNum;
    @SerializedName("note_num")
    private int noteNum;
    @SerializedName("end_year")
    private long endYear;

    @SerializedName("trans_title")
    //
    private String transTitle;
    @SerializedName("perio_title")
    //
    private String perioTitle;
    @SerializedName("perio_desc")
    //
    private String perioDesc;
    @SerializedName("keywords")
    //
    private String keywords;
    @SerializedName("summary")
    //
    private String summary;
    @SerializedName("class_type")
    //
    private String classType;

    @SerializedName("class_code")
    //
    private String classCode;

    @SerializedName("classcode_level")
    //
    private String classcodeLevel;

    @SerializedName("hostunit_name")
    //
    private String hostunitName;

    @SerializedName("main_column")
    //
    private String mainColumn;

    @SerializedName("core_perio")
    //
    private String corePerio;


    @SerializedName("win_prize")
    //
    private String winPrize;

    private String flag ="0";




}
