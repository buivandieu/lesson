package com.vti.dto;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportsDTO extends RepresentationModel<ReportsDTO> {

	private int id;

	private int employee;
	
	private String content;

	private Date created_date ;

	

//	private List<AccountDTO> accounts;
//
//	@Data
//	@NoArgsConstructor
//	public static class AccountDTO extends RepresentationModel<DepartmentDTO> {
//
//		@JsonProperty("accountId")
//		private int id;
//
//		private String username;
//	}
}

