package com.hexaware.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexawre.model.Employee;
import com.hexawre.model.ResponseValidation;

@RestController
public class EmployeeController {


	@PostMapping(path = "/jsonValidation", consumes = {"application/json"})
	public ResponseEntity<ResponseValidation> addEmployee(@Valid @RequestBody Employee employee){
		ResponseValidation response = new ResponseValidation("VALID");
		return ResponseEntity.ok(response);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseValidation handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    ResponseValidation response = new ResponseValidation("ERROR");
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        response.getErrors().add(errorMessage);
	    });
	    return response;
	}
}
