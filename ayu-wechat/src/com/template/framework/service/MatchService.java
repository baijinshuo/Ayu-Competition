package com.template.framework.service;

import com.template.framework.domain.Match;

public interface MatchService {
	public Integer addMatchInfo(Match match);

	public Match getByOrderNo(String out_trade_no);

	public void updateMatch(Match match);
}
