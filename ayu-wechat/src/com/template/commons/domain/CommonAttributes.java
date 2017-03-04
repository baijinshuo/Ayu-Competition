/*
 * Copyright 2005-2013 cloudhope.com.cn. All rights reserved.
 * Support: http://www.cloudhope.com.cn
 * License: http://www.cloudhope.com.cn/license
 */
package com.template.commons.domain;

/**
 * 公共参数
 * 
 * @author xiedonghua
 * @version 1.0
 */
public final class CommonAttributes {

	/** 日期格式配比 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss" };

	/**
	 * 不可实例化
	 */
	private CommonAttributes() {
	}

}
