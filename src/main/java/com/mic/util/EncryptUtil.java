package com.mic.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EncryptUtil.class);
	
	public static String encryptMD5(String pwd) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pwd.getBytes());
			
			StringBuffer stringBuffer = new StringBuffer();
			
			int  n;
			byte[] b = md.digest();
			
			for (int i = 0; i < b.length; i++) {
				n = b[i];
				
				if (n < 0) {
					n += 256;
				}
				
//				stringBuffer.append(Integer.toHexString(n / 16) + Integer.toHexString(n % 16));
				
				if (n < 16) {
					stringBuffer.append("0");
				}
				
				stringBuffer.append(Integer.toHexString(n));
			}
			
			return stringBuffer.toString();
			
		} catch (NoSuchAlgorithmException e) {
			
			LOGGER.info("Encrypt Error");
			return null;
		}
	}
}
