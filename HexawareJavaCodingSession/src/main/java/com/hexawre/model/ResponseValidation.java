package com.hexawre.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseValidation {
	
	public ResponseValidation(String status) {
		this.status = status;
	}
	
	private String status = "Error";
	private List<String> errors = new ArrayList<String> ();
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
