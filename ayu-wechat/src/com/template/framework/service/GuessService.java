package com.template.framework.service;

import java.util.List;

import com.template.framework.domain.GuessItem;
import com.template.framework.domain.GuessUserAnswerItem;

public interface GuessService {
	List<GuessItem> getLatestGuessOnlyA();
	
	List<GuessItem> getGuessOnlyBByGuessId(Integer guessId);
	/**
	 * 提交竟猜结果
	 * 
	 * @param guessId
	 * @param openid
	 * @param guessItemList
	 */
	boolean insertGuessAnswer(Integer guessId, String openid, List<GuessItem> guessItemList);
	/**
	 * 提交一次竟猜答案，返回插入的主键值
	 * @param guessId
	 * @param openid
	 * @param guessItem
	 * @return
	 */
	int insertGuessAnswer(Integer guessId, String openid, GuessItem guessItem);

	/**
	 * 判断用户是否参与过最近的竟猜 true:参与过 false:没有参与过
	 * 
	 * @param openid
	 * @return
	 */
	boolean isPartakeLatestGuess(String openid);

	int updateAnswerItem(GuessUserAnswerItem item);
}
