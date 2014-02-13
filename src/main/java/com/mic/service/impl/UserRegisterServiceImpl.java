package com.mic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mic.dao.UserInfoDao;
import com.mic.exception.BizException;
import com.mic.exception.ErrMessage;
import com.mic.model.UserInfo;
import com.mic.service.UserRegisterService;
import com.mic.util.ParameterUtils;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	
	@Resource
	private UserInfoDao userInfoDao;
	
	public void register(String name, String email, String tel, String pwd, String nickname) {
		
		ParameterUtils.checkEmail(email);
		ParameterUtils.checkPhoneNum(tel);
		
		int num = userInfoDao.getUserInfoNum(name, email, tel);
		
		if (num != 0) {
			throw new BizException(ErrMessage.Repeated_Registration_CODE, ErrMessage.Repeated_Registration);
		}
		
		UserInfo userInfo = new UserInfo(name, email, tel, pwd, nickname);
		userInfoDao.save(userInfo);
	}
}
