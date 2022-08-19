package com.vti.form.employees;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatingEmployeesForm {

	private int id;
	
	@NotBlank(message = "The username's mustn't be null value")
	@Length(max = 50,min = 6, message = "The username's length is max 50 characters,min 6 characters")
	private String username;
	
	
	
	@NotBlank(message = "The firstName's mustn't be null value")
	@Length(max = 50, message = "The firstName's length is max 50 characters")
	private String firstName ;
	
	@NotBlank(message = "The lastName's mustn't be null value")
	@Length(max = 50, message = "The lastName's length is max 50 characters")
	private String lastName ;
	
	@Pattern(regexp = "ADMIN|EMPLOYEE|MANAGER", message = "The type must be ADMIN, EMPLOYEE or MANAGER  ")
	private String role ;

	@PositiveOrZero(message = "The departmentId must be greater than or equal 0")
	private int departmentId;

}

