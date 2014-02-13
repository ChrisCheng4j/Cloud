package com.mic.dao;

import com.mic.model.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo, Long> {
	
	int getUserInfoNum(String name, String email, String tel) ;
}
