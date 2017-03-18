package com.template.framework.dao;

import org.apache.ibatis.annotations.Param;

import com.template.framework.domain.GuessUserAnswer;

public interface GuessUserAnswerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(GuessUserAnswer record);

	int insertSelective(GuessUserAnswer record);

	GuessUserAnswer selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(GuessUserAnswer record);

	int updateByPrimaryKey(GuessUserAnswer record);

	GuessUserAnswer getAnswerByGuessIdAndOpenid(@Param("guessId") Integer guessId, @Param("openid") String openid);
}
