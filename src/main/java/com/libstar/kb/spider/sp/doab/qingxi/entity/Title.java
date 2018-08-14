package com.libstar.kb.spider.sp.doab.qingxi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author 李增光
 * @create 2018-08-14 14:10
 **/
@Entity
public class Title {
    private long kbcId;
    private String coverUrl;
    private String beginDate;
    private String endDate;
    private String doi;
    private String countryCode;
    private String bookSizeCode;
    private String currencyCode;
    private String langCode;
    private String carrierCode;
    private String pressCode;
    private Integer docTypeCode;
    private String callNum;
    private BigDecimal price;
    private String classNo;
    private Integer classCode;
    private String courseClass;
    private Integer createBy;
    private Timestamp createDate;
    private Integer updateBy;
    private Timestamp updateDate;
    private String url;
    private String platform;

    @Id
    @Column(name = "KBC_ID", nullable = false)
    public long getKbcId() {
        return kbcId;
    }

    public void setKbcId(long kbcId) {
        this.kbcId = kbcId;
    }

    @Basic
    @Column(name = "COVER_URL", nullable = true, length = 255)
    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Basic
    @Column(name = "BEGIN_DATE", nullable = true, length = 60)
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "END_DATE", nullable = true, length = 30)
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "DOI", nullable = true, length = 255)
    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    @Basic
    @Column(name = "COUNTRY_CODE", nullable = true, length = 20)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "BOOK_SIZE_CODE", nullable = true, length = 20)
    public String getBookSizeCode() {
        return bookSizeCode;
    }

    public void setBookSizeCode(String bookSizeCode) {
        this.bookSizeCode = bookSizeCode;
    }

    @Basic
    @Column(name = "CURRENCY_CODE", nullable = true, length = 20)
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "LANG_CODE", nullable = true, length = 20)
    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    @Basic
    @Column(name = "CARRIER_CODE", nullable = true, length = 20)
    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    @Basic
    @Column(name = "PRESS_CODE", nullable = true, length = 20)
    public String getPressCode() {
        return pressCode;
    }

    public void setPressCode(String pressCode) {
        this.pressCode = pressCode;
    }

    @Basic
    @Column(name = "DOC_TYPE_CODE", nullable = true)
    public Integer getDocTypeCode() {
        return docTypeCode;
    }

    public void setDocTypeCode(Integer docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    @Basic
    @Column(name = "CALL_NUM", nullable = true, length = 20)
    public String getCallNum() {
        return callNum;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "CLASS_NO", nullable = true, length = 100)
    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    @Basic
    @Column(name = "CLASS_CODE", nullable = true)
    public Integer getClassCode() {
        return classCode;
    }

    public void setClassCode(Integer classCode) {
        this.classCode = classCode;
    }

    @Basic
    @Column(name = "COURSE_CLASS", nullable = true, length = 500)
    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    @Basic
    @Column(name = "CREATE_BY", nullable = true)
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "CREATE_DATE", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "UPDATE_BY", nullable = true)
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "UPDATE_DATE", nullable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "URL", nullable = true, length = 400)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "PLATFORM", nullable = true, length = 255)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return kbcId == title.kbcId &&
                Objects.equals(coverUrl, title.coverUrl) &&
                Objects.equals(beginDate, title.beginDate) &&
                Objects.equals(endDate, title.endDate) &&
                Objects.equals(doi, title.doi) &&
                Objects.equals(countryCode, title.countryCode) &&
                Objects.equals(bookSizeCode, title.bookSizeCode) &&
                Objects.equals(currencyCode, title.currencyCode) &&
                Objects.equals(langCode, title.langCode) &&
                Objects.equals(carrierCode, title.carrierCode) &&
                Objects.equals(pressCode, title.pressCode) &&
                Objects.equals(docTypeCode, title.docTypeCode) &&
                Objects.equals(callNum, title.callNum) &&
                Objects.equals(price, title.price) &&
                Objects.equals(classNo, title.classNo) &&
                Objects.equals(classCode, title.classCode) &&
                Objects.equals(courseClass, title.courseClass) &&
                Objects.equals(createBy, title.createBy) &&
                Objects.equals(createDate, title.createDate) &&
                Objects.equals(updateBy, title.updateBy) &&
                Objects.equals(updateDate, title.updateDate) &&
                Objects.equals(url, title.url) &&
                Objects.equals(platform, title.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kbcId, coverUrl, beginDate, endDate, doi, countryCode, bookSizeCode, currencyCode, langCode, carrierCode, pressCode, docTypeCode, callNum, price, classNo, classCode, courseClass, createBy, createDate, updateBy, updateDate, url, platform);
    }
}
