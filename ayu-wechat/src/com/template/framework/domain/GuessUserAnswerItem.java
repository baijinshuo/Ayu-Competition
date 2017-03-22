package com.template.framework.domain;

import java.util.Date;

public class GuessUserAnswerItem {
    private Integer id;

    private Integer answerId;

    private Integer guessItemId;

    private Integer answer;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getGuessItemId() {
        return guessItemId;
    }

    public void setGuessItemId(Integer guessItemId) {
        this.guessItemId = guessItemId;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
