package com.template.framework.dao;

import com.template.framework.domain.WxUser;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
    
    WxUser selectByOpenid(String openid);
}
