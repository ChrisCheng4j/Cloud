package com.mic.exception;

public class BizException extends RuntimeException{
	
	private static final long serialVersionUID = 7375079288755297575L;
	
	private String desc;

	public BizException(String str, String desc) {
		super(str);
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}
