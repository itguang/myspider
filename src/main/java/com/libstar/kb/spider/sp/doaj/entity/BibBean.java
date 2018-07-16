package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-16 11:22
 **/
@Data
public class BibBean {


    /**
     * start_page : 1737
     * title : Study progresses on continuous curvilinear capsulorhexis
     * abstract : As the progress of modern techniques for cataract extraction surgery and various needs of intraocular lens(IOL)implantation, continuous curvilinear capsulorhexis(CCC)is still in absolute dominance among different ways of incision of anterior capsular lens in clinical practices, due to its advantages such as smoothness of capsulor opening, strong anti-tearing ability, integrity of supporting capsular bag, and strength at maintaining IOL stability. This article describes in general the historical development of CCC and complementary methods adapted to raise success rate when it is used in special cases of cataract extraction surgery. Meanwhile, the article also discusses briefly and envisions the prospects of femotsecond laser applied in CCC technique for cataract extraction.
     * author : [{"affiliation":"Department of Ophthalmology, No.2 People's Hospital of Xintai, Xintai 271200, Shandong Province, China","name":"Bo Gao"},{"affiliation":"Department of Ophthalmology, Yankuang Group General Hospital, Jining 273500, Shandong Province, China","name":"Mao-Lan Yang"},{"affiliation":"Department of Ophthalmology, Affiliated Hospital of Taishan Medical University, Tai'an 271000, Shandong Province, China","name":"Jiu-Min Yuan"}]
     * subject : [{"scheme":"LCC","term":"Ophthalmology","code":"RE1-994"}]
     * month : 10
     * link : [{"url":"http://ies.ijo.cn/cn_publish/2015/10/201510016.pdf","type":"fulltext"}]
     * year : 2015
     * keywords : ["continuous curvilinear capsulorhexis","special cataracts","puncture of posterior chamber central canal of stilling","femtosecond laser"]
     * identifier : [{"type":"doi","id":"10.3980/j.issn.1672-5123.2015.10.16"},{"type":"pissn","id":"1672-5123"},{"type":"eissn","id":"1672-5123"}]
     * journal : {"publisher":"Press of International Journal of Ophthalmology (IJO PRESS)","license":[{"url":"http://ies.ijo.cn/gjykcn/ch/reader/view_news.aspx?id=20130815015707001","open_access":true,"type":"CC BY-NC-ND","title":"CC BY-NC-ND"}],"language":["EN"],"title":"Guoji Yanke Zazhi","country":"CN","number":"10","volume":"15","issns":["1672-5123"]}
     * end_page : 1740
     */

    @SerializedName("start_page")
    private String startPage;
    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String abstractX;
    @SerializedName("month")
    private String month;
    @SerializedName("year")
    private String year;
    @SerializedName("journal")
    private JournalBean journal;
    @SerializedName("end_page")
    private String endPage;
    @SerializedName("author")
    private List<AuthorBean> author;
    @SerializedName("subject")
    private List<SubjectBean> subject;
    @SerializedName("link")
    private List<LicenseBean> link;
    @SerializedName("keywords")
    private List<String> keywords;
    @SerializedName("identifier")
    private List<IdentifierBean> identifier;

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public JournalBean getJournal() {
        return journal;
    }

    public void setJournal(JournalBean journal) {
        this.journal = journal;
    }

    public String getEndPage() {
        return endPage;
    }

    public void setEndPage(String endPage) {
        this.endPage = endPage;
    }

    public List<AuthorBean> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorBean> author) {
        this.author = author;
    }

    public List<SubjectBean> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectBean> subject) {
        this.subject = subject;
    }

    public List<LicenseBean> getLink() {
        return link;
    }

    public void setLink(List<LicenseBean> link) {
        this.link = link;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<IdentifierBean> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<IdentifierBean> identifier) {
        this.identifier = identifier;
    }
}
