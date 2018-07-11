package com.libstar.kb.spider.sp.cspd.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author itguang
 * @create 2018-06-27 20:01
 **/
public class PerioFundBean {
    /**
     * article_id : ycyyzz201705003
     * record_id : 10981592
     * project_id : 160005154A515001/016/001
     * project_seq : 2
     * id : 14e66fa7-1e82-44ad-b473-039e2e80b670
     * project_name : 华东师范大学教育学高峰学科建设项目
     */

    @SerializedName("article_id")
    private String articleId;
    @SerializedName("record_id")
    private String recordId;
    @SerializedName("project_id")
    private String projectId;
    @SerializedName("project_seq")
    private String projectSeq;
    @SerializedName("id")
    private String id;
    @SerializedName("project_name")
    private String projectName;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectSeq() {
        return projectSeq;
    }

    public void setProjectSeq(String projectSeq) {
        this.projectSeq = projectSeq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
