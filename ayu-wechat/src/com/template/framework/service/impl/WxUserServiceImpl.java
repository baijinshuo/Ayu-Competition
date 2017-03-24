package com.template.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.framework.dao.WxUserMapper;
import com.template.framework.domain.WxUser;
import com.template.framework.service.WxUserService;

@Service
public class WxUserServiceImpl implements WxUserService{
	@Autowired
	private WxUserMapper wxUserMapper;
	@Override
	public WxUser selectByOpenid(String openid) {
		return wxUserMapper.selectByOpenid(openid);
	}

	@Override
	public Integer insertWxUser(WxUser wxUser) {
		return wxUserMapper.insertSelective(wxUser);
	}

	@Override
	public Integer updateWxUser(WxUser wxUser) {
		return wxUserMapper.updateByPrimaryKeySelective(wxUser);
	}
	
}
