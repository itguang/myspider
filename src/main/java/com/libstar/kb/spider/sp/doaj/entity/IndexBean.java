package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-16 9:59
 **/
@Data
public class IndexBean {
    /**
     * publisher : ["Press of International Journal of Ophthalmology (IJO PRESS)"]
     * schema_subject : ["LCC:Ophthalmology"]
     * date : 2015-10-01T00:00:00Z
     * license : ["CC BY-NC-ND"]
     * classification : ["Ophthalmology"]
     * language : ["English"]
     * country : China
     * date_toc_fv_month : 2015-10-01T00:00:00Z
     * issn : ["1672-5123"]
     * unpunctitle : Study progresses on continuous curvilinear capsulorhexis
     * classification_paths : ["Medicine: Ophthalmology"]
     * has_seal : No
     * schema_code : ["LCC:RE1-994"]
     * asciiunpunctitle : Study progresses on continuous curvilinear capsulorhexis
     * subject : ["Ophthalmology"]
     */

    @SerializedName("date")
    private String date;
    @SerializedName("country")
    private String country;
    @SerializedName("date_toc_fv_month")
    private String dateTocFvMonth;
    @SerializedName("unpunctitle")
    private String unpunctitle;
    @SerializedName("has_seal")
    private String hasSeal;
    @SerializedName("asciiunpunctitle")
    private String asciiunpunctitle;
    @SerializedName("publisher")
    private List<String> publisher;
    @SerializedName("schema_subject")
    private List<String> schemaSubject;
    @SerializedName("license")
    private List<String> license;
    @SerializedName("classification")
    private List<String> classification;
    @SerializedName("language")
    private List<String> language;
    @SerializedName("issn")
    private List<String> issn;
    @SerializedName("classification_paths")
    private List<String> classificationPaths;
    @SerializedName("schema_code")
    private List<String> schemaCode;
    @SerializedName("subject")
    private List<String> subject;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateTocFvMonth() {
        return dateTocFvMonth;
    }

    public void setDateTocFvMonth(String dateTocFvMonth) {
        this.dateTocFvMonth = dateTocFvMonth;
    }

    public String getUnpunctitle() {
        return unpunctitle;
    }

    public void setUnpunctitle(String unpunctitle) {
        this.unpunctitle = unpunctitle;
    }

    public String getHasSeal() {
        return hasSeal;
    }

    public void setHasSeal(String hasSeal) {
        this.hasSeal = hasSeal;
    }

    public String getAsciiunpunctitle() {
        return asciiunpunctitle;
    }

    public void setAsciiunpunctitle(String asciiunpunctitle) {
        this.asciiunpunctitle = asciiunpunctitle;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public List<String> getSchemaSubject() {
        return schemaSubject;
    }

    public void setSchemaSubject(List<String> schemaSubject) {
        this.schemaSubject = schemaSubject;
    }

    public List<String> getLicense() {
        return license;
    }

    public void setLicense(List<String> license) {
        this.license = license;
    }

    public List<String> getClassification() {
        return classification;
    }

    public void setClassification(List<String> classification) {
        this.classification = classification;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getIssn() {
        return issn;
    }

    public void setIssn(List<String> issn) {
        this.issn = issn;
    }

    public List<String> getClassificationPaths() {
        return classificationPaths;
    }

    public void setClassificationPaths(List<String> classificationPaths) {
        this.classificationPaths = classificationPaths;
    }

    public List<String> getSchemaCode() {
        return schemaCode;
    }

    public void setSchemaCode(List<String> schemaCode) {
        this.schemaCode = schemaCode;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }
}
