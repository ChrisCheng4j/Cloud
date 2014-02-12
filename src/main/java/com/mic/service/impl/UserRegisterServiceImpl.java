package com.mic.service.impl;

import org.springframework.stereotype.Service;

import com.mic.service.UserRegisterService;
import com.mic.util.ParameterUtils;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	public void register(String name, String email, String tel, String pwd, String nickname) {
		
		ParameterUtils.checkEmail(email);
		ParameterUtils.checkPhoneNum(tel);
	}
}
