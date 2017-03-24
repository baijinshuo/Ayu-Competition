package com.template.framework.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.template.framework.dao.GuessItemMapper;
import com.template.framework.dao.GuessMapper;
import com.template.framework.dao.GuessUserAnswerItemMapper;
import com.template.framework.dao.GuessUserAnswerMapper;
import com.template.framework.domain.Guess;
import com.template.framework.domain.GuessItem;
import com.template.framework.domain.GuessUserAnswer;
import com.template.framework.domain.GuessUserAnswerItem;
import com.template.framework.domain.WxUser;
import com.template.framework.service.GuessService;
import com.template.framework.service.WxUserService;

@Service
public class GuessServiceImpl implements GuessService {
	@Autowired
	private GuessMapper guessMapper;
	@Autowired
	private GuessItemMapper guessItemMapper;
	@Autowired
	private GuessUserAnswerMapper answerMapper;
	@Autowired
	private GuessUserAnswerItemMapper answerItemMapper;
	@Autowired
	private WxUserService wxUserService;

	@Override
	public List<GuessItem> getLatestGuessOnlyA() {
		Guess guess = guessMapper.getLatestGuess();
		if (guess != null) {
			List<GuessItem> itemAList = guessItemMapper.getItemByGuessIdAndType(guess.getId(), 1);
			return itemAList;
		}
		return null;
	}

	/**
	 * guessItemList各个对象中id和result必须有值，result此时代表用户提交的答案
	 */
	@Override
	public boolean insertGuessAnswer(Integer guessId, String openid, List<GuessItem> guessItemList) {
		Integer answerId = addOrGetAnswerId(guessId, openid);
		if (answerId != null) {
			for (GuessItem item : guessItemList) {
				GuessUserAnswerItem answerItem = new GuessUserAnswerItem();
				answerItem.setAnswerId(answerId);
				answerItem.setCreateTime(new Date());
				answerItem.setGuessItemId(item.getId());
				// 设置用户提交的答案
				answerItem.setAnswer(item.getResult());
				answerItemMapper.insert(answerItem);
			}
			return true;
		}
		return false;
	}

	/**
	 * 竟猜B轮时该记录已经生成
	 * 
	 * @param guessId
	 * @param openid
	 * @return
	 */
	private Integer addOrGetAnswerId(Integer guessId, String openid) {
		GuessUserAnswer answer = answerMapper.getAnswerByGuessIdAndOpenid(guessId, openid);
		// 存在 获取anserId
		if (answer != null) {
			return answer.getId();
		} else {
			// 不存在 新增返回answerId
			GuessUserAnswer userAnswer = new GuessUserAnswer();
			userAnswer.setCreateTime(new Date());
			userAnswer.setGuessId(guessId);
			Guess guess = guessMapper.selectByPrimaryKey(guessId);
			userAnswer.setGuessIssue(guess.getIssue());
			WxUser wxUser = wxUserService.selectByOpenid(openid);
			userAnswer.setNickname(wxUser.getNickname());
			userAnswer.setOpenid(openid);
			userAnswer.setRedpacketStatus(0);
			int status = answerMapper.insert(userAnswer);
			if (status == 1) {
				return userAnswer.getId();
			}
		}
		return null;
	}

	@Override
	public boolean isPartakeLatestGuess(String openid) {
		Guess guess = guessMapper.getLatestGuess();
		GuessUserAnswer answer = answerMapper.getAnswerByGuessIdAndOpenid(guess.getId(), openid);
		return answer == null ? false : true;
	}

	@Override
	public List<GuessItem> getGuessOnlyBByGuessId(Integer guessId) {
		return guessItemMapper.getItemByGuessIdAndType(guessId, 2);
	}

	@Override
	public int insertGuessAnswer(Integer guessId, String openid, GuessItem guessItem) {
		Integer answerId = addOrGetAnswerId(guessId, openid);
		if (answerId != null) {
			GuessUserAnswerItem answerItem = new GuessUserAnswerItem();
			answerItem.setAnswerId(answerId);
			answerItem.setCreateTime(new Date());
			answerItem.setGuessItemId(guessItem.getId());
			// 设置用户提交的答案
			answerItem.setAnswer(guessItem.getResult());
			answerItemMapper.insert(answerItem);
			return answerItem.getId();
		}
		return -1;
	}

	@Override
	public int updateAnswerItem(GuessUserAnswerItem item) {
		return answerItemMapper.updateByPrimaryKeySelective(item);
	}

}
