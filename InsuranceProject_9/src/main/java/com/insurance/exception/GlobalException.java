package com.insurance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = IdNotFoundException.class)
	@ResponseBody
	public ErrorResponse handleIdNotFoundException(IdNotFoundException exp) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exp.getMessage());
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseBody
	public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException exp) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exp.getMessage());

	}

}
