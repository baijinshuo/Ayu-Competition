package com.template.commons.domain;

public class UserTraces {
	/** 客户端IP */
	private String clientIP;
	/** 请求路径 */
	private String requestURL;
	/** 请求时间 */
	private String requestTime;
	/** 请求参数 */
	private Object requestParam;
	/** 客户端环境 */
	private String userAgent;
	/** 父URL */
	private String referer;

	/** 获取客户端IP */
	public String getClientIP() {
		return clientIP;
	}

	/** 设置客户端IP */
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	/** 设置获取请求路径 */
	public String getRequestURL() {
		return requestURL;
	}

	/** 设置请求路径 */
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	/** 获取请求时间 */
	public String getRequestTime() {
		return requestTime;
	}

	/** 设置请求时间 */
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	/** 获取请求参数 */
	public Object getRequestParam() {
		return requestParam;
	}

	/** 设置请求参数 */
	public void setRequestParam(Object requestParam) {
		this.requestParam = requestParam;
	}

	/** 客户端环境 */
	public String getUserAgent() {
		return userAgent;
	}

	/** 客户端环境 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/** 父URL */
	public String getReferer() {
		return referer;
	}

	/** 父URL */
	public void setReferer(String referer) {
		this.referer = referer;
	}

}
