package com.template.framework.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sword.wechat4j.user.Oauth;
import org.sword.wechat4j.user.OauthUser;
import org.sword.wechat4j.user.UserManager;

import com.template.commons.utils.StringUtil;
import com.template.framework.domain.Manage;
import com.template.framework.domain.WxUser;
import com.template.framework.service.ManageService;
import com.template.framework.service.WxUserService;

@Controller
@RequestMapping("/wxAuth")
public class WxAuthController {
	private static final Logger log = LoggerFactory.getLogger(WxAuthController.class);
	@Autowired
	private ManageService manageService;
	@Autowired
	private WxUserService wxUserService;

	/**
	 * 只有月赛报名时候不需要传url
	 * 
	 * @param url
	 * @return
	 */
	@RequestMapping("/authUrl")
	public String authUrl(String url) {
		if (StringUtil.isEmpty(url)) {
			url = "http://wx.16ayu.com/wxAuth/matchAuth";
		}
		String oauthUrl = UserManager.oauthUrl(url, "snsapi_base");
		return "redirect:" + oauthUrl;
	}

	/**
	 * 再次授权获取详细信息 ，只有月赛报名时候不需要传url
	 * 
	 * @param url
	 * @return
	 */
	@RequestMapping("/authInfoUrl")
	public String authInfoUrl(String url) {
		if (StringUtil.isEmpty(url)) {
			url = "http://wx.16ayu.com/wxAuth/matchAuth1";
		}
		String oauthUrl = UserManager.oauthUrl(url, "snsapi_userinfo");
		return "redirect:" + oauthUrl;
	}

	/**
	 * 授权后进入比赛首页
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	@RequestMapping("/matchAuth")
	public String matchAuth(HttpServletRequest request, String code) {
		try {
			if (StringUtils.isBlank(code)) {
				throw new RuntimeException("code为空，请求非法！");
			}
			boolean auth = auth(request, code);
			if (auth) {
				Manage manage = manageService.findByType(1);
				if (manage != null && manage.getStatus() == 1) {
					return "redirect:/match/index";
				}
				return "redirect:/wxAuth/end";
			} else {
				return "redirect:/wxAuth/authInfoUrl";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 授权后进入比赛首页
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	@RequestMapping("/matchAuth1")
	public String matchAuth1(HttpServletRequest request, String code) {
		try {
			if (StringUtils.isBlank(code)) {
				throw new RuntimeException("code为空，请求非法！");
			}
			boolean auth = authInfo(request, code);
			if (auth) {
				Manage manage = manageService.findByType(1);
				if (manage != null && manage.getStatus() == 1) {
					return "redirect:/match/index";
				}
				return "redirect:/wxAuth/end";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 授权后进入竟猜首页
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	@RequestMapping("/guessAuth")
	public String guessAuth(HttpServletRequest request, String code) {
		try {
			if (StringUtils.isBlank(code)) {
				throw new RuntimeException("code为空，请求非法！");
			}
			boolean auth = auth(request, code);
			if (auth) {
				Manage manage = manageService.findByType(2);
				if (manage != null && manage.getStatus() == 1) {
					return "redirect:/guess/index";
				}
				return "redirect:/guess/end";
			} else {
				return "redirect:/wxAuth/authInfoUrl?url=http://wx.16ayu.com/wxAuth/guessAuth1";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 授权后进入竟猜首页
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	@RequestMapping("/guessAuth1")
	public String guessAuth1(HttpServletRequest request, String code) {
		try {
			if (StringUtils.isBlank(code)) {
				throw new RuntimeException("code为空，请求非法！");
			}
			boolean auth = authInfo(request, code);
			if (auth) {
				Manage manage = manageService.findByType(2);
				if (manage != null && manage.getStatus() == 1) {
					return "redirect:/guess/index";
				}
				return "redirect:/guess/end";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 进入未授权页面
	 * 
	 * @return
	 */
	@RequestMapping("/unauth")
	public String unauth() {
		return "unauth";
	}

	/**
	 * 到月赛关注页面
	 * 
	 * @return
	 */
	@RequestMapping("/follow")
	public String follow() {
		return "match/follow";
	}

	/**
	 * 到竟猜关注页面
	 * 
	 * @return
	 */
	@RequestMapping("/guessFollow")
	public String guessFollow() {
		return "guess/follow";
	}

	/**
	 * 报名结束
	 * 
	 * @return
	 */
	@RequestMapping("/end")
	public String end() {
		return "match/end";
	}

	/*************************************************************************************************************/
	/**
	 * 授权页面,获取微信用户openid
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	private boolean auth(HttpServletRequest request, String code) {
		// 先从数据库获取
		Oauth oauth = UserManager.oauth(code);
		if (oauth != null && StringUtils.isNotBlank(oauth.getOpenid())) {
			log.info("openid: " + oauth.getOpenid());
			WxUser wxUser = wxUserService.selectByOpenid(oauth.getOpenid());
			if (wxUser != null) {
				request.getSession().setAttribute("wxUser", wxUser);
				return true;
			}
		}
		return false;
	}

	/**
	 * 授权页面,获取微信用户详细信息
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	private boolean authInfo(HttpServletRequest request, String code) {
		// 数据库不存在则调用接口获取,并入库用户信息
		OauthUser wxUser = UserManager.oauthGetUserInfo(code);
		if (wxUser != null) {
			WxUser user2 = wxUserService.selectByOpenid(wxUser.getOpenid());
			WxUser user = user2;
			if (user2 == null) {
				user = new WxUser();
				user.setCity(wxUser.getCity());
				user.setCountry(wxUser.getCountry());
				user.setHeadimgurl(wxUser.getHeadimgurl());
				user.setLanguage(wxUser.getLanguage());
				user.setNickname(wxUser.getNickname());
				user.setOpenid(wxUser.getOpenid());
				user.setProvince(wxUser.getProvince());
				user.setSex(wxUser.getSex());
				wxUserService.insertWxUser(user);
			}
			request.getSession().setAttribute("wxUser", user);
			return true;
		}
		return false;
	}
}
