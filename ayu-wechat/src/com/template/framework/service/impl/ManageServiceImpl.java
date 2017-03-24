package com.template.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.framework.dao.ManageMapper;
import com.template.framework.domain.Manage;
import com.template.framework.service.ManageService;
@Service
public class ManageServiceImpl implements ManageService{
	@Autowired
	private ManageMapper manageMapper;
	@Override
	public Manage findByType(Integer match_type) {
		return manageMapper.findByType(match_type);
	}

}
