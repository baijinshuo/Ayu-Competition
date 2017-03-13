package com.template.commons.utils;

/**
 * 短信工具类
 * 
 * @author yyx
 * @date 2015年3月17日
 *
 */
public class SMSUtil {
	/**
	 * 手机号格式验证 (1:移动 2:联通 3:电信 4:格式错误)
	 * @param phone_number
	 * @return
	 */
	public static int matchesPhoneNumber(String phone_number) { 

		String cm = "^((13[4-9])|(14[7,8])|(15[0-2,7-9])|(18[2-4,7-8]))\\d{8}$"; 
		String cu = "^((13[0-2])|(145)|(15[5-6])|(18[5,6]))\\d{8}$"; 
		String ct = "^((133)|(15[3,4])|(17[1,7])|(18[0,1,9]))\\d{8}$"; 

		int flag = 0; 
		if (phone_number.matches(cm)) { 
		flag = 1; 
		} else if (phone_number.matches(cu)) { 
		flag = 2; 
		} else if (phone_number.matches(ct)) { 
		flag = 3; 
		} else { 
		flag = 4; 
		} 
		return flag; 

		} 
}
