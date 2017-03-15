package com.template.framework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.template.commons.domain.Result;
import com.template.framework.domain.GuessItem;
import com.template.framework.domain.GuessUserAnswerItem;
import com.template.framework.domain.WxUser;
import com.template.framework.service.GuessService;
import com.template.framework.vo.GuessItemList;

/**
 * 竟猜
 * 
 * @author lijiejun
 *
 */
@Controller
@RequestMapping("/guess")
public class GuessController {
	private static final Logger log = LoggerFactory.getLogger(GuessController.class);
	@Autowired
	private GuessService guessService;

	/**
	 * 到竟猜介绍页 并查出是否参与最近的竟猜 isPartak=true为参与过
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		try {
			WxUser wxUser = (WxUser) request.getSession().getAttribute("wxUser");
			boolean flag = guessService.isPartakeLatestGuess(wxUser.getOpenid());
			if (flag) {
				model.addAttribute("isPartake", true);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "guess/index";
	}

	/**
	 * 到竟猜页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String guess(HttpServletRequest request, Model model) {
		try {
			// 再次判断是否参与过本次竟猜，如果参与过调转到已竟猜过页面
			WxUser wxUser = (WxUser) request.getSession().getAttribute("wxUser");
			boolean flag = guessService.isPartakeLatestGuess(wxUser.getOpenid());
			if (flag) {
				return "guess/ispartake";
			}
			List<GuessItem> guessItemList = guessService.getLatestGuessOnlyA();
			model.addAttribute("guessItemList", guessItemList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "guess/guess";
	}

	/**
	 * 竟猜用户答案提交 -3:已经参与过
	 * 
	 * @param items
	 * @param request
	 * @param response
	 */
	@RequestMapping("/submitGuessAnswer")
	public void submitGuessAnswer(GuessItemList items, HttpServletRequest request, HttpServletResponse response) {
		try {
			WxUser wxUser = (WxUser) request.getSession().getAttribute("wxUser");
			boolean flag1 = guessService.isPartakeLatestGuess(wxUser.getOpenid());
			if (flag1) {
				response.getWriter().write("-3");
				return;
			}
			if (items.getItems() == null || items.getItems().size() == 0) {
				response.getWriter().write("-1");
				return;
			}
			List<GuessItem> itemList = new ArrayList<GuessItem>();
			Integer guessId = items.getItems().get(0).getGuessId();
			for (GuessItem guessItem : items.getItems()) {
				if (guessId != guessItem.getGuessId()) {
					response.getWriter().write("-1");
					return;
				}
				// 答B轮
				if (guessItem.getType() == 2) {
					itemList.add(guessItem);
				}
				// 答A轮
				if (itemList.isEmpty()) {
					itemList.addAll(items.getItems());
				}
			}
			boolean flag = guessService.insertGuessAnswer(guessId, wxUser.getOpenid(), itemList);
			if (flag) {
				response.getWriter().write("0");
				return;
			} else {
				response.getWriter().write("-2");
				return;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 加载对应排期的B轮竟猜 0：成功 -1：不存在B轮竟猜
	 * 
	 * @param guessId
	 * @param response
	 */
	@RequestMapping("/loadGuessOnlyB")
	public void loadGuessOnlyB(Integer guessId, HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/javascript;charset=utf-8");
		Result result = new Result();
		WxUser wxUser = (WxUser) request.getSession().getAttribute("wxUser");
		try {
			List<GuessItem> itemBList = guessService.getGuessOnlyBByGuessId(guessId);
			if (itemBList != null && itemBList.size() > 0) {
				int id = guessService.insertGuessAnswer(guessId, wxUser.getOpenid(), itemBList.get(0));
				result.setResultcode("0");
				result.setResultmessage(id + "");
				result.setData(itemBList);
				response.getWriter().write(JSON.toJSONString(result));
			} else {
				result.setResultcode("-1");
				response.getWriter().write(JSON.toJSONString(result));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@RequestMapping("/updateAnswer")
	public void updateAnswer(Integer id, Integer result, HttpServletResponse response) {
		try {
			GuessUserAnswerItem item = new GuessUserAnswerItem();
			item.setId(id);
			item.setAnswer(result);
			guessService.updateAnswerItem(item);
			response.getWriter().write("0");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@RequestMapping("/end")
	public String end() {
		return "guess/end";
	}

	@RequestMapping("/success")
	public String success() {
		return "guess/success";
	}
}
