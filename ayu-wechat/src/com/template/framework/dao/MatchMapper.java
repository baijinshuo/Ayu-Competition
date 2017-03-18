package com.template.framework.dao;

import com.template.framework.domain.Match;

public interface MatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Match record);

    int insertSelective(Match record);

    Match selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Match record);

    int updateByPrimaryKey(Match record);

	Match getByOrderNo(String out_trade_no);
}
