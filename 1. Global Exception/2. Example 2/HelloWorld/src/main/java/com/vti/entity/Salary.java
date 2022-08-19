package com.vti.entity;

import java.io.Serializable;

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

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;



import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Salary")
@Data
@NoArgsConstructor
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "number_of_day_work" , nullable = false)
	@ColumnDefault("0") 
	private int numberOfDayWork;


	@Column(name = "absent_days" , nullable = false)
	@ColumnDefault("0") 
	private int firstName;
	
	@Column(name = "salary", length = 50, nullable = false)
	@ColumnDefault("0") 
	private int salary;
	
	@Column(name = "employee_id" , nullable = false)
	private int employee_id;
	
	
	
//	@ManyToOne
//	@JoinColumn(name = "department_id", nullable = false)
//	private Department department;
	
	
}
