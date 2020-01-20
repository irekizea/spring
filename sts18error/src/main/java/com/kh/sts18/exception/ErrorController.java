package com.kh.sts18.exception;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(annotations = Controller.class)
@ControllerAdvice(basePackages = {"com.kh.sts18"})
public class ErrorController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@ExceptionHandler(SQLException.class)
	public String sqlHandler(Exception ex) {
		logger.error("DB 제대로써", ex);
		return "error/500";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String hander(Exception ex) {
		logger.error("제대로 써", ex);
		return "error/500";
		
//		Exception
//		- RuntimeException
//		- IOException
//		- SQL Exception
		
	}
	
}
