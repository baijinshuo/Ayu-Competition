package com.template.framework.domain;

import java.math.BigDecimal;
import java.util.Date;

public class GuessUserAnswer {
    private Integer id;

    private Integer guessId;

    private String guessIssue;

    private String openid;

    private String nickname;

    private Integer redpacketStatus;

    private BigDecimal redpacketMoney;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuessId() {
        return guessId;
    }

    public void setGuessId(Integer guessId) {
        this.guessId = guessId;
    }

    public String getGuessIssue() {
        return guessIssue;
    }

    public void setGuessIssue(String guessIssue) {
        this.guessIssue = guessIssue;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRedpacketStatus() {
        return redpacketStatus;
    }

    public void setRedpacketStatus(Integer redpacketStatus) {
        this.redpacketStatus = redpacketStatus;
    }

    public BigDecimal getRedpacketMoney() {
        return redpacketMoney;
    }

    public void setRedpacketMoney(BigDecimal redpacketMoney) {
        this.redpacketMoney = redpacketMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
