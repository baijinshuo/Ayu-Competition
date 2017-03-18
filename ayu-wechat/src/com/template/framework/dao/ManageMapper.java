package com.template.framework.dao;

import com.template.framework.domain.Manage;

public interface ManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
    
    Manage findByType(Integer match_type);
}
