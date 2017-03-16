package com.template.framework.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.template.framework.domain.Match;
import com.template.framework.domain.WxUser;
import com.template.framework.service.MatchService;

@Controller
@RequestMapping("/match")
public class MatchController {
	private static final Logger log = LoggerFactory.getLogger(MatchController.class);
	@Autowired
	private MatchService matchService;

	@RequestMapping("/submitInfo")
	public String submitInfo(HttpServletRequest request, Match match, Model model) {
		try {
			match.setOrderNo("ayu" + System.currentTimeMillis() + "");
			match.setStatus(0);
			match.setCreateTime(new Date());
			match.setMoney(50);
			WxUser wxUser = (WxUser) request.getSession().getAttribute("wxUser");
			match.setOpenid(wxUser.getOpenid());
			match.setNickname(wxUser.getNickname());
			matchService.addMatchInfo(match);
			model.addAttribute("match", match);
			return "match/pay";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	@RequestMapping("/index")
	public String index() {
		return "match/index";
	}

	@RequestMapping("/toAddInfo")
	public String toAddInfo() {
		return "match/match_info";
	}

	@RequestMapping("/toPay")
	public String toPay() {
		return "match/pay";
	}
}
