package com.mic.exception;

public class BizException extends RuntimeException {
	
	private static final long serialVersionUID = 7375079288755297575L;
	
	private String errCode;
	private String message;

	public BizException(String errCode, String message) {
		this.errCode = errCode;
		this.message = message;
	}
	
	public String getErrCode() {
		return errCode;
	}

	public String getMessage() {
		return message;
	}
}
