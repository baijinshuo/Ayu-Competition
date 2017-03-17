package com.template.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.template.framework.domain.GuessItem;

public interface GuessItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GuessItem record);

    int insertSelective(GuessItem record);

    GuessItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GuessItem record);

    int updateByPrimaryKey(GuessItem record);

	List<GuessItem> getItemByGuessIdAndType(@Param("guessId") Integer guessId,@Param("type") Integer type);
}
