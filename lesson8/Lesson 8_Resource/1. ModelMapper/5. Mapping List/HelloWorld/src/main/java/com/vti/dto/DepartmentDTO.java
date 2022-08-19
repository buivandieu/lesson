package com.vti.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {

	private String name;
	private String type;
	private Date createdDate;
	private List<AccountDTO> accounts;

	@Data
	@NoArgsConstructor
	static class AccountDTO {
		private int id;
		private String username;
	}
}

