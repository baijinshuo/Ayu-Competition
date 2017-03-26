package com.template.framework.service;

import com.template.framework.domain.Manage;

public interface ManageService {
	public Manage findByType(Integer match_type);
}
