package com.mic.test;

import org.junit.Test;

import com.mic.util.TelephoneValidator;

public class TestTelephoneValidator {
	
	@Test
	public void test() {
		System.out.println(TelephoneValidator.isValid("11111111111"));
	}
}
