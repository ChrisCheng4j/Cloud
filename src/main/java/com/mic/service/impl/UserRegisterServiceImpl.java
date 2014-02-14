package com.mic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mic.dao.UserAlbumDao;
import com.mic.dao.UserInfoDao;
import com.mic.exception.BizException;
import com.mic.exception.ErrMessage;
import com.mic.model.UserAlbum;
import com.mic.model.UserInfo;
import com.mic.service.UserRegisterService;
import com.mic.util.EncryptUtil;
import com.mic.util.Global;
import com.mic.util.ParameterUtils;

/**
 * Implement the function of Register
 * If register successfully then will create a default album & will send an email if email is not null.
 * 
 * @author chrischeng
 */

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	
	@Resource
	private UserInfoDao userInfoDao;
	
	@Resource
	private UserAlbumDao userAlbumDao;
	
	/**
	 * Send an email if email is not null
	 * 
	 * @param name
	 * @param email
	 * @param tel
	 * @param pwd
	 * @param nickname
	 */
	public void register(String name, String email, String tel, String pwd, String nickname) {
		
		checkParameter(nickname, email, tel);
		
		UserInfo userInfo = new UserInfo(name, email, tel, EncryptUtil.encryptMD5(pwd), nickname, 0L);
		Long userId = userInfoDao.save(userInfo);
		createDefaultAlbum(userId);
	}
	
	/**
	 * Check Parameter Valid and if exist
	 * 
	 * @param name
	 * @param email
	 * @param tel
	 */
	public void checkParameter(String name, String email, String tel) {
		
		ParameterUtils.checkAllEmpty(email, tel);
		
		if (email != null) {
			ParameterUtils.checkEmail(email);
		}
		
		if (tel != null) {
			ParameterUtils.checkPhoneNum(tel);
		}
		
		int num = userInfoDao.getUserInfoNum(name, email, tel);
		
		if (num != 0) {
			throw new BizException(ErrMessage.Repeated_Registration_CODE, ErrMessage.Repeated_Registration);
		}
	}
	
	/**
	 * Creatre a default album when register successfully
	 * 
	 * @param userId
	 */
	public void createDefaultAlbum(Long userId) {
		
		UserAlbum userAlbum = new UserAlbum(userId, Global.DEFAULT_ALBUM_NAME, Global.DEFAULT_ALBUM_CLASSIFICATION, "Public");
		userAlbum.setUpdateDate(userAlbum.getCreationDate());
		
		userAlbumDao.save(userAlbum);
	}
}
