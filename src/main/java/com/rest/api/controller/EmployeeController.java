package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.exception.ControllerException;
import com.rest.api.exception.ServiceException;
import com.rest.api.model.Employee;
import com.rest.api.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empServiceImpl;

	@PostMapping("/saveemp")
	public ResponseEntity<?> saveEmp(@RequestBody Employee emp) {
		//try {
			Employee savedemp = empServiceImpl.saveEmployee(emp);
			return new ResponseEntity<Employee>(savedemp, HttpStatus.CREATED);
	//	} catch (ServiceException e) {
//			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			ControllerException ce = new ControllerException("611", "Something bad happen in controller");
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//		}
	}

	@GetMapping("/getallemp")
	public ResponseEntity<List<Employee>> findAllEmployee() {
		List<Employee> emplist = empServiceImpl.getAllEmployee();
		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);
	}

	@GetMapping("/getempbyid/{emp_id}")
	public ResponseEntity<?> findById(@PathVariable("emp_id") Long id) {
		//try {
			Employee findEmpById = empServiceImpl.getEmployeeById(id);
			return new ResponseEntity<Employee>(findEmpById, HttpStatus.OK);
		//} catch (ServiceException e) {
		//	ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
		//	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		//} catch (Exception e) {
			//ControllerException ce = new ControllerException("611", "Something bad happen in controller");
			//return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	//	}
	}

	@PutMapping("/updateemp/{id}")
	public ResponseEntity<?> updateEmp(@RequestBody Employee emp, @PathVariable Long id) {
	//	try {
			Employee updateEmp = empServiceImpl.updateEmployee(emp, id);
			return new ResponseEntity<Employee>(updateEmp, HttpStatus.RESET_CONTENT);
		//} catch (ServiceException e) {
//			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			ControllerException ce = new ControllerException("611", "Something bad happen in controller");
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//		}
	}

	@DeleteMapping("/deleteemp/{id}")
	public void deleteEmp(@PathVariable Long id) {
		 empServiceImpl.deleteEmployee(id);

	}
}
