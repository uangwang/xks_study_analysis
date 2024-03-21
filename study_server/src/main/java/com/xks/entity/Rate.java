package com.xks.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Rate)实体类
 *
 * @author makejava
 * @since 2024-03-22 00:43:38
 */
public class Rate implements Serializable {
    private static final long serialVersionUID = -89802849204361636L;
    /**
     * 时间
     */
    private Date time;
    /**
     * 章节
     */
    private String chapter;
    /**
     * 做题量
     */
    private Integer qNum;
    /**
     * 错题量
     */
    private Integer errorNum;
    /**
     * 正确率
     */
    private String correctRate;


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Integer getQNum() {
        return qNum;
    }

    public void setQNum(Integer qNum) {
        this.qNum = qNum;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }

    public String getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(String correctRate) {
        this.correctRate = correctRate;
    }

}

