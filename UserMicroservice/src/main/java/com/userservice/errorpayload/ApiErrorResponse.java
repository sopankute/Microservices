package com.userservice.errorpayload;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorResponse {
	
	private HttpStatus status;
    private String message;
    private String errorCode;
    private LocalDateTime timestamp;
    private String path;
}
