package com.mic.exception;

public interface ErrorMessage {
	
	/**
	 * Invalid Parameters
	 */
	public final String INVALID_ARGUMENT_CODE = "001";
	public final String INVALID_ARGUMENT = "Invalid Argument";
	
	public final String INVALID_EMAIL_CODE = "002";
	public final String INVALID_EMAIL = "Invalid Email";
	
	public final String INVALID_PHONENUM_CODE = "003";
	public final String INVALID_PHONENUM = "Invalid Phone Number";
	
	public final String INVALID_PICTURE_TYPE_CODE = "004";
	public final String INVALID_PICTURE_TYPE = "Not A Picture Type";
	
	public final String UPLOAD_NULL_CODE = "005";
	public final String UPLOAD_NULL = "No Upload";
	
	/**
	 * User Operation Forbidden
	 */
	public final String Repeated_Registration_CODE = "101";
	public final String Repeated_Registration = "Repeated Registration";
	
	public final String ALBUM_NOT_EXISTS_CODE = "102";
	public final String ALBUM_NOT_EXISTS = "Album NOT exists";
	
	/**
	 * System Error
	 */	
	public final String GET_FILETYPE_ERROR_CODE = "201";
	public final String GET_FILETYPE_ERROR= "Failed to get file type";
}
