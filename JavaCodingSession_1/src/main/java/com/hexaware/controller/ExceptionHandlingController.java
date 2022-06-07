package com.hexaware.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hexaware.exceptions.ResourceNotFoundException;
import com.hexaware.exceptions.UnauthorizedException;
import com.hexaware.model.ResponseValidation;

@RestController
public class ExceptionHandlingController extends ResponseEntityExceptionHandler{


	@PostMapping(path = "/testExceptionHandling")
	public ResponseEntity<ResponseValidation>  getAlien(@RequestParam("code")int code) throws Exception {
		ResponseValidation responseValidation = new ResponseValidation();
		responseValidation.setErrorMessage("ok");
		
		if(code==404) {
			throw new ResourceNotFoundException("Resource not found");
		}else if(code == 401) {
			throw new UnauthorizedException("You are not authorized");
		}else
			return ResponseEntity.ok(responseValidation);
		
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseValidation handleResourceNotFoundException(
			ResourceNotFoundException ex) {
	    ResponseValidation response = new ResponseValidation();
	    response.setErrorMessage(ex.getMessage());
	    return response;
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseValidation handleUnauthorizedException(
			UnauthorizedException ex) {
	    ResponseValidation response = new ResponseValidation();
	    response.setErrorMessage(ex.getMessage());
	    return response;
	}
	
}
