package com.yash.ytms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yash.ytms.utilities.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	 @ExceptionHandler(ResourceNotFoundException.class)
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse response = new ApiResponse(ex.getMessage(), false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	 @ExceptionHandler(DuplicateCompetencyException.class)
	 public ResponseEntity<ApiResponse> handleDuplicateCompetencyException(DuplicateCompetencyException ex) 
	 {
	        ApiResponse response = new ApiResponse(ex.getMessage(), false);
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	

}
