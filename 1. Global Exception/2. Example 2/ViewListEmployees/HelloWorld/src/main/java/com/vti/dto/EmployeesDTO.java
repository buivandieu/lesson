package com.vti.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeesDTO extends RepresentationModel<DepartmentDTO> {

	private int id;

	private String username;
	
	private String fisrtname;
	
	private String lastname;
	
	private String email;
	
	private int department_id;
	
	private String role;
	
	private String status;
	
	

	
}
