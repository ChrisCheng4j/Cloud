package com.mic.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface PictureService {
	
	void upload(Long userId, Long albumId, CommonsMultipartFile picture);
}
