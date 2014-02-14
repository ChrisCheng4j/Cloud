package com.mic.util;

import java.util.Collection;

import org.apache.commons.validator.EmailValidator;

import com.mic.exception.BizException;
import com.mic.exception.ErrMessage;

/**
 * Check Format of Parameters
 * @author chrischeng
 *
 */
public class ParameterUtils {
	
	public static void checkEmail(String email) {
		checkEmpty(email);
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new BizException(ErrMessage.INVALID_EMAIL_CODE, ErrMessage.INVALID_EMAIL);
		}
	}
	
	public static void checkPhoneNum(String tel) {
		checkEmpty(tel);
		if (!TelephoneValidator.isValid(tel)) {
			throw new BizException(ErrMessage.INVALID_PHONENUM_CODE, ErrMessage.INVALID_PHONENUM);
		}
	}
	
	/**
	 * Check not Null
	 * @param o
	 */
	public static void checkEmpty(Object o) {
		if (isEmpty(o)) {
			throw new BizException(ErrMessage.INVALID_ARGUMENT_CODE, ErrMessage.INVALID_ARGUMENT);
		}
	}
	
	public static void checkAllEmpty(Object... params) {
		for (Object param : params) {
			if (!isEmpty(param)) {
				return ;
			}
		}
		
		throw new BizException(ErrMessage.INVALID_ARGUMENT_CODE, ErrMessage.INVALID_ARGUMENT);
	}
	
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		
		if (o instanceof Character) {
			if (((Character) o).charValue() == '\0') {
				return true;
			}
		}
		
		if (o instanceof String) {
			if (((String) o).equalsIgnoreCase(null)) {
				return true;
			}
		}
		
		if (o instanceof Collection) {
			if (((Collection<?>) o).size() == 0) {
				return true;
			}
		}
		
		return false;
	}
}
