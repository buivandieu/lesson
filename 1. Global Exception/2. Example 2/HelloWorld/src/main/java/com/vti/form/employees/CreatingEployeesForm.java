package com.vti.form.employees;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingEployeesForm {

	private String username;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String password;
	
	private int department_id;
	
	private String role;
	
	private int status;

	
}

