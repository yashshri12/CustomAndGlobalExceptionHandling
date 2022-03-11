package com.rest.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emp_id;
	private String emp_name;
	private String emp_address;
	private String emp_department;
	private String emp_email;
	private Long emp_salary;
	
}
