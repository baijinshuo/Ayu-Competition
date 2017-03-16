package com.template.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sword.wechat4j.pay.WxPayManager;

import com.template.commons.utils.StringUtil;
import com.template.framework.domain.Match;
import com.template.framework.service.MatchService;

@Controller
@RequestMapping("/wxpay")
public class WxPayController {
	private static final Logger log=LoggerFactory.getLogger(WxPayController.class);
	@Autowired
	private MatchService matchService;
	@RequestMapping("/pay")
	public void pay(String out_trade_no,String openid,HttpServletResponse response,HttpServletRequest request){
		try {
			response.setContentType("text/javascript;charset=utf-8");
			String param = WxPayManager.getJSAPIParam(out_trade_no, "阿彧比赛官方报名费", 5000, "http://wx.16ayu.com/wxpay/notify", request.getRemoteAddr(), openid);
			response.getWriter().write(param);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	@RequestMapping("/notify")
	public void notify(HttpServletRequest request,HttpServletResponse response){
		try {
			response.setContentType("text/javascript;charset=utf-8");
			SAXReader reader = new SAXReader();
			Document document = reader.read(request.getInputStream());
			Element root = document.getRootElement();
			String transaction_id = root.element("transaction_id").getText();
			String out_trade_no = root.element("out_trade_no").getText();
			if(StringUtil.isNotEmpty(out_trade_no)&&StringUtil.isNotEmpty(transaction_id)){
				Match match=matchService.getByOrderNo(out_trade_no);
				if(match!=null&&match.getStatus()==0){
					match.setStatus(1);
					match.setThirdOrderNo(transaction_id);
					matchService.updateMatch(match);
				}
				response.getWriter().write(notifySuccess());
				
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	/**
	 * 通知成功
	 * 
	 * @return
	 */
	private String notifySuccess() {
		return "<xml><return_code>SUCCESS</return_code><return_msg></return_msg></xml>";
	}
}
