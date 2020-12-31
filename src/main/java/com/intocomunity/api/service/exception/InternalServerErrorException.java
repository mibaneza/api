package com.intocomunity.api.service.exception;

;
import com.intocomunity.api.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;


public class InternalServerErrorException extends MensajeException{
	

	private static final long serialVersionUID = 1L;

	public InternalServerErrorException(String code, String message) {
		super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(),message);
	}
	
	public InternalServerErrorException(String code, String message, ErrorDTO data) {
		super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(),message, Arrays.asList(data));
	}

}