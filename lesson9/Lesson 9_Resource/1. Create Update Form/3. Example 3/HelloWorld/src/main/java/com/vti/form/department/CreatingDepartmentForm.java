package com.vti.form.department;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {

	private String name;

	private int totalMember;

	private String type;
	
	private List<Account> accounts;

	@Data
	@NoArgsConstructor
	public static class Account {
		private String username;
	}

}

