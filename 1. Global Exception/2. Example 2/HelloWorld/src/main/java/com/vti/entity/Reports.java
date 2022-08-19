package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;



import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`Reports`")
@Data
@NoArgsConstructor
public class Reports implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "content", length = 50, nullable = false, unique = true)
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date created_date ;

	@Column(name = "employee_id" , nullable = false)
	private int employeeId;
	
//	@ManyToOne
//	@JoinColumn(name = "employee_id", nullable = false)
//	private Employees employeesReports;
	

}
