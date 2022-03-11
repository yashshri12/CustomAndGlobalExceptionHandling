package com.rest.api.service;

import java.util.List;

import com.rest.api.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(Long id);
	public Employee updateEmployee(Employee emp, Long id);
	public void deleteEmployee(Long id);
}
