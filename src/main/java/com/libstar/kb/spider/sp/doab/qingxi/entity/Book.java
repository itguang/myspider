package com.libstar.kb.spider.sp.doab.qingxi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author 李增光
 * @create 2018-08-14 14:10
 **/
@Entity
public class Book {
    private long kbcId;
    private String pressCode;
    private String cip;
    private String title;
    private String transTitle;
    private String alternateTitle;
    private String author;
    private String authorEn;
    private String authorInfo;
    private String isbn10;
    private String isbn13;
    private String eisbn;
    private String publisher;
    private String compEntity;
    private String pubDate;
    private Integer pubYear;
    private String pubLoc;
    private String version;
    private Integer versionTimes;
    private String docAbstract;
    private Integer pages;
    private Integer printTimes;
    private Timestamp printDate;
    private Integer wordCount;
    private String dataSource;
    private String seriesTitles;
    private String seriesEditor;
    private String seriesVol;
    private String subjectTerms;
    private String subject;
    private String keywords;
    private String volume;
    private String volumeNum;
    private Integer timesCited;
    private Integer referNum;
    private String reference;
    private String impactFactor;
    private String imageAddress;
    private String fulltextLink;
    private String catalog;
    private String preface;
    private String review;
    private String docField;
    private String oclc;
    private String bibtex;
    private String marcId;
    private String printIsbn;
    private String onlineIsbn;
    private Integer createBy;
    private Timestamp createDate;
    private Integer updateBy;
    private Timestamp updateDate;

    @Id
    @Column(name = "KBC_ID", nullable = false)
    public long getKbcId() {
        return kbcId;
    }

    public void setKbcId(long kbcId) {
        this.kbcId = kbcId;
    }

    @Basic
    @Column(name = "PRESS_CODE", nullable = true, length = 50)
    public String getPressCode() {
        return pressCode;
    }

    public void setPressCode(String pressCode) {
        this.pressCode = pressCode;
    }

    @Basic
    @Column(name = "CIP", nullable = true, length = 20)
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    @Basic
    @Column(name = "TITLE", nullable = true, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "TRANS_TITLE", nullable = true, length = 1000)
    public String getTransTitle() {
        return transTitle;
    }

    public void setTransTitle(String transTitle) {
        this.transTitle = transTitle;
    }

    @Basic
    @Column(name = "ALTERNATE_TITLE", nullable = true, length = 1000)
    public String getAlternateTitle() {
        return alternateTitle;
    }

    public void setAlternateTitle(String alternateTitle) {
        this.alternateTitle = alternateTitle;
    }

    @Basic
    @Column(name = "AUTHOR", nullable = true, length = 1000)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "AUTHOR_EN", nullable = true, length = 1000)
    public String getAuthorEn() {
        return authorEn;
    }

    public void setAuthorEn(String authorEn) {
        this.authorEn = authorEn;
    }

    @Basic
    @Column(name = "AUTHOR_INFO", nullable = true, length = -1)
    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    @Basic
    @Column(name = "ISBN10", nullable = true, length = 20)
    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    @Basic
    @Column(name = "ISBN13", nullable = true, length = 20)
    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    @Basic
    @Column(name = "EISBN", nullable = true, length = 40)
    public String getEisbn() {
        return eisbn;
    }

    public void setEisbn(String eisbn) {
        this.eisbn = eisbn;
    }

    @Basic
    @Column(name = "PUBLISHER", nullable = true, length = 500)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "COMP_ENTITY", nullable = true, length = 500)
    public String getCompEntity() {
        return compEntity;
    }

    public void setCompEntity(String compEntity) {
        this.compEntity = compEntity;
    }

    @Basic
    @Column(name = "PUB_DATE", nullable = true, length = 50)
    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Basic
    @Column(name = "PUB_YEAR", nullable = true)
    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }

    @Basic
    @Column(name = "PUB_LOC", nullable = true, length = 100)
    public String getPubLoc() {
        return pubLoc;
    }

    public void setPubLoc(String pubLoc) {
        this.pubLoc = pubLoc;
    }

    @Basic
    @Column(name = "VERSION", nullable = true, length = 50)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "VERSION_TIMES", nullable = true)
    public Integer getVersionTimes() {
        return versionTimes;
    }

    public void setVersionTimes(Integer versionTimes) {
        this.versionTimes = versionTimes;
    }

    @Basic
    @Column(name = "DOC_ABSTRACT", nullable = true, length = 4000)
    public String getDocAbstract() {
        return docAbstract;
    }

    public void setDocAbstract(String docAbstract) {
        this.docAbstract = docAbstract;
    }

    @Basic
    @Column(name = "PAGES", nullable = true)
    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Basic
    @Column(name = "PRINT_TIMES", nullable = true)
    public Integer getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(Integer printTimes) {
        this.printTimes = printTimes;
    }

    @Basic
    @Column(name = "PRINT_DATE", nullable = true)
    public Timestamp getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Timestamp printDate) {
        this.printDate = printDate;
    }

    @Basic
    @Column(name = "WORD_COUNT", nullable = true)
    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    @Basic
    @Column(name = "DATA_SOURCE", nullable = true, length = 100)
    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Basic
    @Column(name = "SERIES_TITLES", nullable = true, length = 100)
    public String getSeriesTitles() {
        return seriesTitles;
    }

    public void setSeriesTitles(String seriesTitles) {
        this.seriesTitles = seriesTitles;
    }

    @Basic
    @Column(name = "SERIES_EDITOR", nullable = true, length = 100)
    public String getSeriesEditor() {
        return seriesEditor;
    }

    public void setSeriesEditor(String seriesEditor) {
        this.seriesEditor = seriesEditor;
    }

    @Basic
    @Column(name = "SERIES_VOL", nullable = true, length = 100)
    public String getSeriesVol() {
        return seriesVol;
    }

    public void setSeriesVol(String seriesVol) {
        this.seriesVol = seriesVol;
    }

    @Basic
    @Column(name = "SUBJECT_TERMS", nullable = true, length = 1000)
    public String getSubjectTerms() {
        return subjectTerms;
    }

    public void setSubjectTerms(String subjectTerms) {
        this.subjectTerms = subjectTerms;
    }

    @Basic
    @Column(name = "SUBJECT", nullable = true, length = 500)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "KEYWORDS", nullable = true, length = 500)
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "VOLUME", nullable = true, length = 100)
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "VOLUME_NUM", nullable = true, length = 100)
    public String getVolumeNum() {
        return volumeNum;
    }

    public void setVolumeNum(String volumeNum) {
        this.volumeNum = volumeNum;
    }

    @Basic
    @Column(name = "TIMES_CITED", nullable = true)
    public Integer getTimesCited() {
        return timesCited;
    }

    public void setTimesCited(Integer timesCited) {
        this.timesCited = timesCited;
    }

    @Basic
    @Column(name = "REFER_NUM", nullable = true)
    public Integer getReferNum() {
        return referNum;
    }

    public void setReferNum(Integer referNum) {
        this.referNum = referNum;
    }

    @Basic
    @Column(name = "REFERENCE", nullable = true, length = 100)
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "IMPACT_FACTOR", nullable = true, length = 100)
    public String getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(String impactFactor) {
        this.impactFactor = impactFactor;
    }

    @Basic
    @Column(name = "IMAGE_ADDRESS", nullable = true, length = 500)
    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    @Basic
    @Column(name = "FULLTEXT_LINK", nullable = true, length = 500)
    public String getFulltextLink() {
        return fulltextLink;
    }

    public void setFulltextLink(String fulltextLink) {
        this.fulltextLink = fulltextLink;
    }

    @Basic
    @Column(name = "CATALOG", nullable = true, length = -1)
    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    @Basic
    @Column(name = "PREFACE", nullable = true, length = -1)
    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    @Basic
    @Column(name = "REVIEW", nullable = true, length = -1)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "DOC_FIELD", nullable = true, length = -1)
    public String getDocField() {
        return docField;
    }

    public void setDocField(String docField) {
        this.docField = docField;
    }

    @Basic
    @Column(name = "OCLC", nullable = true, length = 20)
    public String getOclc() {
        return oclc;
    }

    public void setOclc(String oclc) {
        this.oclc = oclc;
    }

    @Basic
    @Column(name = "BIBTEX", nullable = true, length = 50)
    public String getBibtex() {
        return bibtex;
    }

    public void setBibtex(String bibtex) {
        this.bibtex = bibtex;
    }

    @Basic
    @Column(name = "MARC_ID", nullable = true, length = 30)
    public String getMarcId() {
        return marcId;
    }

    public void setMarcId(String marcId) {
        this.marcId = marcId;
    }

    @Basic
    @Column(name = "PRINT_ISBN", nullable = true, length = 20)
    public String getPrintIsbn() {
        return printIsbn;
    }

    public void setPrintIsbn(String printIsbn) {
        this.printIsbn = printIsbn;
    }

    @Basic
    @Column(name = "ONLINE_ISBN", nullable = true, length = 20)
    public String getOnlineIsbn() {
        return onlineIsbn;
    }

    public void setOnlineIsbn(String onlineIsbn) {
        this.onlineIsbn = onlineIsbn;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return kbcId == book.kbcId &&
                Objects.equals(pressCode, book.pressCode) &&
                Objects.equals(cip, book.cip) &&
                Objects.equals(title, book.title) &&
                Objects.equals(transTitle, book.transTitle) &&
                Objects.equals(alternateTitle, book.alternateTitle) &&
                Objects.equals(author, book.author) &&
                Objects.equals(authorEn, book.authorEn) &&
                Objects.equals(authorInfo, book.authorInfo) &&
                Objects.equals(isbn10, book.isbn10) &&
                Objects.equals(isbn13, book.isbn13) &&
                Objects.equals(eisbn, book.eisbn) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(compEntity, book.compEntity) &&
                Objects.equals(pubDate, book.pubDate) &&
                Objects.equals(pubYear, book.pubYear) &&
                Objects.equals(pubLoc, book.pubLoc) &&
                Objects.equals(version, book.version) &&
                Objects.equals(versionTimes, book.versionTimes) &&
                Objects.equals(docAbstract, book.docAbstract) &&
                Objects.equals(pages, book.pages) &&
                Objects.equals(printTimes, book.printTimes) &&
                Objects.equals(printDate, book.printDate) &&
                Objects.equals(wordCount, book.wordCount) &&
                Objects.equals(dataSource, book.dataSource) &&
                Objects.equals(seriesTitles, book.seriesTitles) &&
                Objects.equals(seriesEditor, book.seriesEditor) &&
                Objects.equals(seriesVol, book.seriesVol) &&
                Objects.equals(subjectTerms, book.subjectTerms) &&
                Objects.equals(subject, book.subject) &&
                Objects.equals(keywords, book.keywords) &&
                Objects.equals(volume, book.volume) &&
                Objects.equals(volumeNum, book.volumeNum) &&
                Objects.equals(timesCited, book.timesCited) &&
                Objects.equals(referNum, book.referNum) &&
                Objects.equals(reference, book.reference) &&
                Objects.equals(impactFactor, book.impactFactor) &&
                Objects.equals(imageAddress, book.imageAddress) &&
                Objects.equals(fulltextLink, book.fulltextLink) &&
                Objects.equals(catalog, book.catalog) &&
                Objects.equals(preface, book.preface) &&
                Objects.equals(review, book.review) &&
                Objects.equals(docField, book.docField) &&
                Objects.equals(oclc, book.oclc) &&
                Objects.equals(bibtex, book.bibtex) &&
                Objects.equals(marcId, book.marcId) &&
                Objects.equals(printIsbn, book.printIsbn) &&
                Objects.equals(onlineIsbn, book.onlineIsbn) &&
                Objects.equals(createBy, book.createBy) &&
                Objects.equals(createDate, book.createDate) &&
                Objects.equals(updateBy, book.updateBy) &&
                Objects.equals(updateDate, book.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kbcId, pressCode, cip, title, transTitle, alternateTitle, author, authorEn, authorInfo, isbn10, isbn13, eisbn, publisher, compEntity, pubDate, pubYear, pubLoc, version, versionTimes, docAbstract, pages, printTimes, printDate, wordCount, dataSource, seriesTitles, seriesEditor, seriesVol, subjectTerms, subject, keywords, volume, volumeNum, timesCited, referNum, reference, impactFactor, imageAddress, fulltextLink, catalog, preface, review, docField, oclc, bibtex, marcId, printIsbn, onlineIsbn, createBy, createDate, updateBy, updateDate);
    }
}
