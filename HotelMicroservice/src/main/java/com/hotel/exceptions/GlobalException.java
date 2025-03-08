package com.hotel.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> handlerReourceNotFound(ResourceNotFoundException ex, WebRequest req){
		
		Map<String, Object> map = new HashMap<>();
		
		String replace = req.getDescription(false).replace("url", "");
		
		map.put("status", HttpStatus.NOT_FOUND);
		map.put("message", ex.getMessage());
		map.put("errorCode", "ENTITY_NOT_FOUND");
		map.put("timestamp", LocalDateTime.now());
		map.put("path", replace);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
	}
	
}
