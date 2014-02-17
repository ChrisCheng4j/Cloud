package com.mic.util;

public enum FileType {
	
	JPEG("FFD8FF"),
	
	PNG("89504E47"),
	
	GIF("47494638"),
	
	BMP("424D"),
	
	PSD("38425053"),
	
	NOTSUPPORTED("");
	
	private String value;
	
	private FileType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
