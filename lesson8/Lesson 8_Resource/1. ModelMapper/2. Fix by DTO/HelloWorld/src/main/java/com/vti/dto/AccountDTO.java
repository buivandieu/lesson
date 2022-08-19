package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor 
public class AccountDTO {

	private int id;
	
	@NonNull
	private String username;

	@NonNull
	private String departmentName;
}

