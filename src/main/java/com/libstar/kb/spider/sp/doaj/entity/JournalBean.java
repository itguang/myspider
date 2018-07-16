package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-16 10:07
 **/
public class JournalBean {
    /**
     * publisher : Press of International Journal of Ophthalmology (IJO PRESS)
     * license : [{"url":"http://ies.ijo.cn/gjykcn/ch/reader/view_news.aspx?id=20130815015707001","open_access":true,"type":"CC BY-NC-ND","title":"CC BY-NC-ND"}]
     * language : ["EN"]
     * title : Guoji Yanke Zazhi
     * country : CN
     * number : 10
     * volume : 15
     * issns : ["1672-5123"]
     */

    @SerializedName("publisher")
    private String publisher;
    @SerializedName("title")
    private String title;
    @SerializedName("country")
    private String country;
    @SerializedName("number")
    private String number;
    @SerializedName("volume")
    private String volume;
    @SerializedName("license")
    private List<LicenseBean> license;
    @SerializedName("language")
    private List<String> language;
    @SerializedName("issns")
    private List<String> issns;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public List<LicenseBean> getLicense() {
        return license;
    }

    public void setLicense(List<LicenseBean> license) {
        this.license = license;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getIssns() {
        return issns;
    }

    public void setIssns(List<String> issns) {
        this.issns = issns;
    }
}
