package com.mic.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mic.service.UserRegisterService;

@Controller
public class RegisterController {
	
	@Resource
	private UserRegisterService userRegisterService;
	
	@RequestMapping(value="/reg.action")
	public void register(@RequestParam("name") String name, 
									@RequestParam(value = "email", required = false) String email,
									@RequestParam(value = "tel", required = false) String tel,
									@RequestParam("pwd") String pwd,
									@RequestParam(value = "nickname", required = false) String nickname) {
		
		userRegisterService.register(name, email, tel, pwd, nickname);
	}
}
