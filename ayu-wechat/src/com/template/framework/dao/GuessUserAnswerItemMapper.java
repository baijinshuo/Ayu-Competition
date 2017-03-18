package com.template.framework.dao;

import com.template.framework.domain.GuessUserAnswerItem;

public interface GuessUserAnswerItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GuessUserAnswerItem record);

    int insertSelective(GuessUserAnswerItem record);

    GuessUserAnswerItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GuessUserAnswerItem record);

    int updateByPrimaryKey(GuessUserAnswerItem record);
}
