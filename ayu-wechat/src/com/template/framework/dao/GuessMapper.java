package com.template.framework.dao;

import com.template.framework.domain.Guess;

public interface GuessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Guess record);

    int insertSelective(Guess record);

    Guess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guess record);

    int updateByPrimaryKey(Guess record);

	Guess getLatestGuess();
}
