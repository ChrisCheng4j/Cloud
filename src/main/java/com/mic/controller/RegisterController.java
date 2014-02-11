package com.mic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/reg.action")
	public void register(@RequestParam("name") String name, 
									@RequestParam(value = "email", required = false) String email,
									@RequestParam(value = "tel", required = false) String tel,
									@RequestParam("pwd") String pwd,
									@RequestParam(value = "nickname", required = false) String nickname) {
			
	}
}
