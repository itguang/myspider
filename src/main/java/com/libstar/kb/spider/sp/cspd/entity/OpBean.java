package com.libstar.kb.spider.sp.cspd.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * @author itguang
 * @create 2018-06-27 20:01
 **/
@Data
public class OpBean {

    @SerializedName("perioUnit")
    private List<PerioUnitBean> perioUnit;
    @SerializedName("perioOldEvaluation")
    private List<PerioOldEvaluationBean> perioOldEvaluation;
    @SerializedName("perioNewEvaluation")
    private List<PerioNewEvaluationBean> perioNewEvaluation;
    @SerializedName("perioAuthors")
    private List<PerioAuthorsBean> perioAuthors;



}
