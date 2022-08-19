package com.vti.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class DepartmentFilterForm {
    
	
	private Integer minId;

	private Integer maxId;

    private Department.Type type;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minCreateDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxCreateDate;
}
