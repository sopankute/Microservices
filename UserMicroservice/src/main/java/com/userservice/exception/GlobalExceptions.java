package com.userservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.userservice.errorpayload.ApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(ResourceNotFoundException.class)	// tells when to execute
	public ResponseEntity<ApiErrorResponse> handleEntityNotFound(ResourceNotFoundException ex, WebRequest request){
		
		ApiErrorResponse response = ApiErrorResponse.builder()
							.status(HttpStatus.NOT_FOUND)
							.message(ex.getMessage())
							.errorCode("ENTITY_NOT_FOUND")
							.timestamp(LocalDateTime.now())
							.path(request.getDescription(false).replace("uri=", ""))
							.build();
				
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
}
