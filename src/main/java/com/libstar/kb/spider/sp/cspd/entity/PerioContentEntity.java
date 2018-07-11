package com.libstar.kb.spider.sp.cspd.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 杂志内目录实体类
 *
 * @author itguang
 * @create 2018-06-27 19:39
 **/
@Data
@Entity
public class PerioContentEntity {


    /**
     * id : perioarticalycyyzz201705003
     * publish_year : 2017
     * hxkbj_nd : 1
     * fund_info02 : ["上海市浦江人才计划项目","华东师范大学教育学高峰学科建设项目"]
     * page_range : 27-39
     * keywords : ["人工智能","人工智能+教育","智能教育","教育人工智能","EAI","教育智能代理","教育Agent","生态系统","人才培养"]
     * page_cnt : 13
     * doc_num : 1672-0008(2017)05-0027-13
     * perio_id : ycyyzz
     * language : chi
     * refdoc_cnt : 0
     * scholar_id : ["23721286","2899960","2904540"]
     * authors_name : ["吴永和","刘博文","马晓玲"]
     * share_num : 0
     * is_summary : 1
     * is_fulltext : 0
     * issue_num : 5
     * pro_pub_date : 1508860800000
     * perio_title02 : 远程教育杂志
     * unit_name : 华东师范大学%
     * linkdoc_cnt : 0
     * issn : 1672-0008
     * unit_name02 : 华东师范大学
     * data_state : add
     * random_id : QKLW_48563B4A899FAC3928277452D0D5173B
     * fund_info : 上海市浦江人才计划项目"基于教育大数据的学习分析教育应用创新研究"(14PJC034)%华东师范大学教育学高峰学科建设项目"基于学习分析的学习资源精准服务研究"(160005154A515001/016/001)的研究成果
     * trans_authors : ["Wu Yonghe","Liu Bowen","Ma Xiaoling"]
     * literature_code : A
     * data_sort : 0
     * new_org : 华东师范大学
     * core_perio : CSSCI
     * publish_year02 : 1483200000000
     * auth_area : ["上海","上海","上海"]
     * article_id : ycyyzz201705003
     * tag_num : 0
     * abstract_reading_num : 311
     * first_authors : 吴永和
     * full_pubdate : 1508428800000
     * common_year : 2017
     * authors_unit : ["华东师范大学 教育学部 教育信息技术学系,上海,200062","华东师范大学 经管学部 信息管理系,上海,200241"]
     * thirdparty_links_num : 0
     * abst_webdate : 1508428800000
     * article_seq : 3
     * import_num : 21
     * common_sort_time : 1508860800000
     * issue_id : ycyyzz_2017_5
     * full_url : ycyyzz/ycyy2017/1705pdf/170503.pdf
     * orig_pub_date : 2017-10-25 00:00:00.0
     * source_db : WF
     * authorsandunit : ["刘博文≡华东师范大学","马晓玲≡华东师范大学 经管学部 信息管理系,上海,200241","吴永和≡华东师范大学"]
     * column_name : 前沿探索
     * cn : 33-1304/G4
     * collection_num : 0
     * download_num : 113
     * orig_classcode : G40-057
     * service_model : 0
     * first_publish : 0
     * is_oa : 0
     * subject_class_codes : G40-057
     * fulltext_reading_num : 0
     * note_num : 0
     * updatetime : 1527064543000
     * head_words : ["人工智能","人工智能+教育","智能教育","教育人工智能","EAI","教育智能代理","教育Agent","生态系统","人才培养"]
     * subject_classcode_level : G40-057
     * perio_title_en : Journal of Distance Education
     * title : 构筑"人工智能+教育"的生态系统
     * summary : 近期国内召开的人工智能教育论坛,进一步促进了"人工智能+教育"研究的深入和应用推广,同时也为人工智能(AI)向"人工智能+教育"发展提供了技术基础.AI发展过程可分别从时间和技术两个维度进行划分,其在发展过程中不断与教育结合,产生了大量的研究成果,这为"人工智能+教育"提供了理论指导.通过高频关键词云图和共词网络图分析透视了目前的研究现状,认为国内外各企业教育智能产品应用,是推进"人工智能+教育"的动力;国家颁布了一系列人工智能发展战略政策,特别强调教育应用,为"人工智能+教育"提供了政策保障.进而从孕育条件、特征、作用三方面阐述了"人工智能+教育"的内涵,从应用形态、技术架构、业态趋向等要素构建了"人工智能+教育"的生态系统,并阐述了"人工智能+教育"的人才培养体系.
     * perio_title : 远程教育杂志
     * trans_title : Constructing an Ecosystem of "Artificial Intelligence+Education"
     * op : {"perioFund":[{"article_id":"ycyyzz201705003","record_id":"10981592","project_id":"160005154A515001/016/001","project_seq":"2","id":"14e66fa7-1e82-44ad-b473-039e2e80b670","project_name":"华东师范大学教育学高峰学科建设项目"},{"article_id":"ycyyzz201705003","record_id":"10981591","project_id":"14PJC034","project_seq":"1","id":"baccd542-90e4-4079-85a0-f7f8dc5c9442","project_name":"上海市浦江人才计划项目"}],"perioUnit":[{"area":"33","area_code":"310030","pubunit_norm":"null","perio_id":"ycyyzz","id":"6bba2915-23f0-4358-93ef-3a3457b4f1ab","pubunit_name":"《远程教育杂志》编辑部"}],"perioOldEvaluation":[{"from_db":"null","affectoi":"8.02799987792969","perio_id":"ycyyzz","id":"a68f933f-a3cc-4a14-9832-a8756dfd65ea","core_version":"2014-2015","core_code":"NJU"},{"from_db":"null","affectoi":"0.963730573654175","perio_id":"ycyyzz","id":"bab8f3c9-b4bf-45b6-8fd5-bbc27779e905","core_version":"2010","core_code":"NJU"},{"from_db":"null","affectoi":"1.41199994087219","perio_id":"ycyyzz","id":"6af1cd80-ab1d-491b-81aa-deb48bfddcd7","core_version":"2012-2013","core_code":"NJU"}],"perioNewEvaluation":[{"from_db":"null","affectoi":"11.0299997329712","perio_id":"ycyyzz","id":"1c412523-b092-4d45-87f5-56b59a1afd27","core_version":"2014-2015","core_code":"NJU"}],"perioAuthors":[{"200241":"","上海":"","perio_id":"ycyyzz","unit_name_en":"null","authors_role":"","scholar_id":"2899960","is_group":"","unit_name":"华东师范大学 经管学部 信息管理系","article_id":"ycyyzz201705003","record_id":"324822","trans_authname":"Ma Xiaoling","org_id":"null","authors_seq":"3","id":"f02d8d79-003d-472c-bd9e-6e8267a16ace","authors_name":"马晓玲","org_name":"null"},{"200062":"","上海":"","perio_id":"ycyyzz","unit_name_en":"null","authors_role":"","scholar_id":"23721286","is_group":"","unit_name":"华东师范大学 教育学部 教育信息技术学系","article_id":"ycyyzz201705003","record_id":"324696","trans_authname":"Liu Bowen","org_id":"13506","authors_seq":"2","id":"83e46f18-f65f-4abc-a4f8-c10c4b73a597","authors_name":"刘博文","org_name":"华东师范大学"},{"200062":"","上海":"","perio_id":"ycyyzz","unit_name_en":"null","authors_role":"","scholar_id":"2904540","is_group":"","unit_name":"华东师范大学 教育学部 教育信息技术学系","article_id":"ycyyzz201705003","record_id":"324851","trans_authname":"Wu Yonghe","org_id":"13506","authors_seq":"1","id":"286df262-a482-47c6-b558-1fde70903226","authors_name":"吴永和","org_name":"华东师范大学"}]}
     * class_type : perio_artical
     * doct_collect : false
     */

    @Id
    @SerializedName("id")
    private String id;
    @SerializedName("publish_year")
    private String publishYear;
    @SerializedName("hxkbj_nd")
    private String hxkbjNd;
    @SerializedName("page_range")
    private String pageRange;
    @SerializedName("page_cnt")
    private int pageCnt;
    @SerializedName("doc_num")
    private String docNum;
    @SerializedName("perio_id")
    private String perioId;
    @SerializedName("language")
    private String language;
    @SerializedName("refdoc_cnt")
    private int refdocCnt;
    @SerializedName("share_num")
    private int shareNum;
    @SerializedName("is_summary")
    private String isSummary;
    @SerializedName("is_fulltext")
    private String isFulltext;
    @SerializedName("issue_num")
    private String issueNum;
    @SerializedName("pro_pub_date")
    private long proPubDate;
    @SerializedName("perio_title02")
    private String perioTitle02;
    @SerializedName("unit_name")
    private String unitName;
    @SerializedName("linkdoc_cnt")
    private int linkdocCnt;
    @SerializedName("issn")
    private String issn;

    @SerializedName("unit_name02")
    @Column(columnDefinition = "text")
    private String unitName02;

    @SerializedName("data_state")
    private String dataState;
    @SerializedName("random_id")
    private String randomId;

    @SerializedName("fund_info")
    @Column(columnDefinition = "text")
    private String fundInfo;

    @SerializedName("literature_code")
    private String literatureCode;
    @SerializedName("data_sort")
    private int dataSort;

    @SerializedName("new_org")
    @Column(columnDefinition = "text")
    private String newOrg;

    @SerializedName("core_perio")
    private String corePerio;
    @SerializedName("publish_year02")
    private long publishYear02;
    @SerializedName("article_id")
    private String articleId;
    @SerializedName("tag_num")
    private int tagNum;
    @SerializedName("abstract_reading_num")
    private int abstractReadingNum;
    @SerializedName("first_authors")
    private String firstAuthors;
    @SerializedName("full_pubdate")
    private long fullPubdate;
    @SerializedName("common_year")
    private String commonYear;
    @SerializedName("thirdparty_links_num")
    private int thirdpartyLinksNum;
    @SerializedName("abst_webdate")
    private long abstWebdate;
    @SerializedName("article_seq")
    private int articleSeq;
    @SerializedName("import_num")
    private int importNum;
    @SerializedName("common_sort_time")
    private long commonSortTime;
    @SerializedName("issue_id")
    private String issueId;
    @SerializedName("full_url")
    private String fullUrl;
    @SerializedName("orig_pub_date")
    private String origPubDate;
    @SerializedName("source_db")
    private String sourceDb;
    @SerializedName("column_name")
    private String columnName;
    @SerializedName("cn")
    private String cn;
    @SerializedName("collection_num")
    private int collectionNum;
    @SerializedName("download_num")
    private int downloadNum;
    @SerializedName("orig_classcode")
    private String origClasscode;
    @SerializedName("service_model")
    private String serviceModel;
    @SerializedName("first_publish")
    private String firstPublish;
    @SerializedName("is_oa")
    private String isOa;
    @SerializedName("subject_class_codes")
    private String subjectClassCodes;
    @SerializedName("fulltext_reading_num")
    private int fulltextReadingNum;
    @SerializedName("note_num")
    private int noteNum;
    @SerializedName("updatetime")
    private long updatetime;
    @SerializedName("subject_classcode_level")
    private String subjectClasscodeLevel;
    @SerializedName("perio_title_en")
    private String perioTitleEn;

    @SerializedName("title")

    private String title;

    @SerializedName("summary")
    @Column(columnDefinition = "text")
    private String summary;

    @SerializedName("perio_title")
    private String perioTitle;
    @SerializedName("trans_title")
    private String transTitle;

    /**
     * 关联表 / @Transient忽略这个字段的自动映射
     */

    @Transient
    private OpBean op;


    @SerializedName("class_type")
    private String classType;
    @SerializedName("doct_collect")
    private boolean doctCollect;
    @SerializedName("fund_info02")
    private String fundInfo02;

    @SerializedName("keywords")
    @Column(columnDefinition = "text")
    private String keywords;

    @SerializedName("scholar_id")
    private String scholarId;


    @SerializedName("authors_name")
    @Column(columnDefinition = "text")
    private String authorsName;

    @SerializedName("trans_authors")
    @Column(columnDefinition = "text")
    private String transAuthors;

    @SerializedName("auth_area")
    @Column(columnDefinition = "text")
    private String authArea;

    @SerializedName("authors_unit")
    @Column(columnDefinition = "text")
    private String authorsUnit;

    @SerializedName("authorsandunit")
    private String authorsandunit;

    @SerializedName("head_words")
    @Column(columnDefinition = "text")
    private String headWords;


}
