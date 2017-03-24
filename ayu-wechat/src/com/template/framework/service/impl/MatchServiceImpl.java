package com.template.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.framework.dao.MatchMapper;
import com.template.framework.domain.Match;
import com.template.framework.service.MatchService;
@Service
public class MatchServiceImpl implements MatchService{
	@Autowired
	private MatchMapper matchMapper;
	@Override
	public Integer addMatchInfo(Match match) {
		return matchMapper.insertSelective(match);
	}
	@Override
	public Match getByOrderNo(String out_trade_no) {
		return matchMapper.getByOrderNo(out_trade_no);
	}
	@Override
	public void updateMatch(Match match) {
		matchMapper.updateByPrimaryKeySelective(match);
	}

}
