package com.mic.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mic.dao.AlbumDao;
import com.mic.exception.BizException;
import com.mic.exception.ErrorMessage;
import com.mic.service.PictureService;
import com.mic.util.FileType;
import com.mic.util.FileTypeJudge;
import com.mic.util.ParameterUtils;

@Service
public class PictureServiceImpl implements PictureService {
	
	@Resource
	private static AlbumDao albumDao;
	
	public void upload(Long userId, Long albumId, CommonsMultipartFile picture) {
		
		checkParameters(userId, albumId, picture);
	}
	
	public void checkParameters(Long userId, Long albumId, CommonsMultipartFile picture) {
		
		ParameterUtils.checkEmpty(userId);
		ParameterUtils.checkEmpty(albumId);
		checkUpload(picture);
		
		if (albumDao.getAlbumNum(userId, albumId) != 1) {
			throw new BizException(ErrorMessage.ALBUM_NOT_EXISTS_CODE, ErrorMessage.ALBUM_NOT_EXISTS);
		}
	}
	
	/**
	 * Check if the upload is null & check its type.
	 * 
	 * @param picture
	 */
	public void checkUpload(CommonsMultipartFile picture) {
		
		ParameterUtils.checkUploadEmpty(picture);
		
		boolean isPicture = false;
		
		try {
			FileType pictureType = FileTypeJudge.getType(picture.getInputStream());
			FileType[] fileTypes = FileType.values();
			
			for (FileType fileType : fileTypes) {
				if (fileType.getValue().equals(pictureType)) {
					isPicture = true;
				}
			}
			
			if (!isPicture) {
				throw new BizException(ErrorMessage.INVALID_PICTURE_TYPE_CODE, ErrorMessage.INVALID_PICTURE_TYPE);
			}
			
		} catch (IOException e) {
			throw new BizException(ErrorMessage.GET_FILETYPE_ERROR_CODE, ErrorMessage.GET_FILETYPE_ERROR);
		}
	}
}
