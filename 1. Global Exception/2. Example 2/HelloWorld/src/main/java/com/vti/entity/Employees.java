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
@Table(name = "`Employees`")
@Data
@NoArgsConstructor
public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;


	@Column(name = "firstname", length = 50 , nullable = false)
	private String firstName;
	
	@Column(name = "lastname", length = 50, nullable = false)
	private String lastName;
	

	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "`password`", length = 100 ,nullable = false) //, nullable = false
	private String password;
	
	@Column(name = "`role`", nullable = false ,columnDefinition = "Employee")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "`status`", length = 50)
	
	private int status;
	
	
//	@ManyToOne
//	@JoinColumn(name = "department_id")
//	@ColumnDefault("1") 
//	private Department department;
	
	public enum Role {
//		ADMIN ,MANAGER,  EMPLOYEE
		Admin ,Manager ,Employee
	}
}
