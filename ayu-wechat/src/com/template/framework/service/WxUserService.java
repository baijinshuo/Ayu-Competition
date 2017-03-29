package com.template.framework.service;

import com.template.framework.domain.WxUser;

public interface WxUserService {
	WxUser selectByOpenid(String openid);
	
	Integer insertWxUser(WxUser wxUser);
	
	Integer updateWxUser(WxUser wxUser);
}
