package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author itguang
 * @create 2018-07-16 9:59
 **/
@Data
public class SourceBean {


    /**
     * index : {"publisher":["Press of International Journal of Ophthalmology (IJO PRESS)"],"schema_subject":["LCC:Ophthalmology"],"date":"2015-10-01T00:00:00Z","license":["CC BY-NC-ND"],"classification":["Ophthalmology"],"language":["English"],"country":"China","date_toc_fv_month":"2015-10-01T00:00:00Z","issn":["1672-5123"],"unpunctitle":"Study progresses on continuous curvilinear capsulorhexis","classification_paths":["Medicine: Ophthalmology"],"has_seal":"No","schema_code":["LCC:RE1-994"],"asciiunpunctitle":"Study progresses on continuous curvilinear capsulorhexis","subject":["Ophthalmology"]}
     * last_updated : 2017-12-12T22:15:00Z
     * admin : {}
     * created_date : 2015-10-13T08:51:37Z
     * id : 000011857dbc42afb0f1a8c7e35ab46f
     * bibjson : {"start_page":"1737","title":"Study progresses on continuous curvilinear capsulorhexis","abstract":"As the progress of modern techniques for cataract extraction surgery and various needs of intraocular lens(IOL)implantation, continuous curvilinear capsulorhexis(CCC)is still in absolute dominance among different ways of incision of anterior capsular lens in clinical practices, due to its advantages such as smoothness of capsulor opening, strong anti-tearing ability, integrity of supporting capsular bag, and strength at maintaining IOL stability. This article describes in general the historical development of CCC and complementary methods adapted to raise success rate when it is used in special cases of cataract extraction surgery. Meanwhile, the article also discusses briefly and envisions the prospects of femotsecond laser applied in CCC technique for cataract extraction.","author":[{"affiliation":"Department of Ophthalmology, No.2 People's Hospital of Xintai, Xintai 271200, Shandong Province, China","name":"Bo Gao"},{"affiliation":"Department of Ophthalmology, Yankuang Group General Hospital, Jining 273500, Shandong Province, China","name":"Mao-Lan Yang"},{"affiliation":"Department of Ophthalmology, Affiliated Hospital of Taishan Medical University, Tai'an 271000, Shandong Province, China","name":"Jiu-Min Yuan"}],"subject":[{"scheme":"LCC","term":"Ophthalmology","code":"RE1-994"}],"month":"10","link":[{"url":"http://ies.ijo.cn/cn_publish/2015/10/201510016.pdf","type":"fulltext"}],"year":"2015","keywords":["continuous curvilinear capsulorhexis","special cataracts","puncture of posterior chamber central canal of stilling","femtosecond laser"],"identifier":[{"type":"doi","id":"10.3980/j.issn.1672-5123.2015.10.16"},{"type":"pissn","id":"1672-5123"},{"type":"eissn","id":"1672-5123"}],"journal":{"publisher":"Press of International Journal of Ophthalmology (IJO PRESS)","license":[{"url":"http://ies.ijo.cn/gjykcn/ch/reader/view_news.aspx?id=20130815015707001","open_access":true,"type":"CC BY-NC-ND","title":"CC BY-NC-ND"}],"language":["EN"],"title":"Guoji Yanke Zazhi","country":"CN","number":"10","volume":"15","issns":["1672-5123"]},"end_page":"1740"}
     */

    @SerializedName("index")
    private IndexBean index;
    @SerializedName("last_updated")
    private String lastUpdated;
    @SerializedName("created_date")
    private String createdDate;
    @SerializedName("id")
    private String id;
    @SerializedName("bibjson")
    private BibBean bibjson;


}
