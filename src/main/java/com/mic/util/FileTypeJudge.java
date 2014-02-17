package com.mic.util;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTypeJudge {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileTypeJudge.class);
	
	public static FileType getType(InputStream is) {
		
		String fileHead = getFileHeader(is);
		FileType[] fileTypes = FileType.values();
		
		for (FileType fileType : fileTypes) {
			if (fileHead.startsWith(fileType.getValue())) {
				return fileType;
			}
		}
		
		return FileType.NOTSUPPORTED;
	}
	
	/**
	 * Get the header of file.
	 * 
	 * @param is
	 * @return 
	 */
	public static String getFileHeader(InputStream is) {
		
		byte[] b = new byte[28];
		
		try {
			is.read(b);
		} catch (IOException e) {
			LOGGER.info("InputStream Reading Error!");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					LOGGER.info("InputStream Closing Error!");
				}
			}
		}
		
		return bytesToHexString(b).toUpperCase();
	}
	
	public static String bytesToHexString(byte[] b) {
		
		if (b == null || b.length < 0) {
			return null;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String hv;
		
		for (int i = 0; i < b.length; i++) {
			hv = Integer.toHexString(b[i] & 0xFF);
			
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			
			stringBuilder.append(hv);
		}
		
		return stringBuilder.toString();	
	}
}
