package com.hexawre.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee {
	

	@Size(min = 4, message= "Name should be at least 4 characters")
	private String name;
	
	@Email(message = "Email is not valid", regexp = "^(.+)@(.+).com$")
	private String email;
	
	@Min(value = 1001, message = "salary should be more than 1000")
	private Float salary;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}

}
