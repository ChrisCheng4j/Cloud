package com.mic.util;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelephoneValidator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TelephoneValidator.class);
	
	private static Pattern isPhoneNumPattern;
	
	private static Perl5Matcher perl5Matcher = new Perl5Matcher();
	
	private static Perl5Compiler perl5Compiler = new Perl5Compiler();
	
	static {
		try {
			isPhoneNumPattern = perl5Compiler.compile("(\\+86)?1\\d{10}");
		} catch (MalformedPatternException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	public static boolean isValid(String tel) {
		return perl5Matcher.matches(tel, isPhoneNumPattern);
	}
}
