package com.intocomunity.api.service.exception;


import com.intocomunity.api.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;


public class NotFountException extends MensajeException{

	private static final long serialVersionUID = 1L;

	public NotFountException(String code, String message) {
		super(code,HttpStatus.NOT_FOUND.value(),message);
	}
	
	public NotFountException(String code, String message, ErrorDTO data) {
		super(code,HttpStatus.NOT_FOUND.value(),message, Arrays.asList(data));
	}

}