package com.mic.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class BizExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
		
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("exception", exception);
		
		if (exception instanceof BizException) {
			
			BizException bizException = (BizException) exception;
			
			modelAndView.addObject("errCode", bizException.getErrCode());
			modelAndView.addObject("message", bizException.getMessage());
		}
		
		return modelAndView;
	}

}
