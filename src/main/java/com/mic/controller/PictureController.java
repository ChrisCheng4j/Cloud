package com.mic.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mic.service.PictureService;

@Controller
public class PictureController {
	
	@Resource
	private PictureService pictureService;
	
	@RequestMapping(value = "/uploadPicture.action")
	public void upload(@RequestParam(value = "userId") Long userId,
									@RequestParam(value = "albumId") Long albumId,
									@RequestParam(value = "picture") CommonsMultipartFile picture) {
		
		pictureService.upload(userId, albumId, picture);
	}
}
