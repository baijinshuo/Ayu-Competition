package com.template.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class WxAuthInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(WxAuthInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handlerMethod, Exception arg3) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handlerMethod, ModelAndView arg3) throws Exception {
	}

	/*
	 * 拦截用户是否登录
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handlerMethod) throws Exception {
//		Object object = request.getSession().getAttribute("openid");
		Object object = request.getSession().getAttribute("wxUser");
		if (object == null) {
			logger.debug("请求{},未登录跳转登录页面", request.getRequestURI());
			response.sendRedirect("/wxAuth/unauth");
			return false;
		}
		return true;
	}

}
