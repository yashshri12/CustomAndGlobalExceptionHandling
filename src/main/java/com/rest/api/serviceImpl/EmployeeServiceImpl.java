package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.exception.EmptyInput;
import com.rest.api.exception.ServiceException;
import com.rest.api.model.Employee;
import com.rest.api.repository.EmployeeRepository;
import com.rest.api.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		//try {
			if (emp.getEmp_name().isEmpty() || emp.getEmp_name().length() == 0||emp.getEmp_email().isEmpty()||emp.getEmp_email().length()==0) {
				throw new EmptyInput("601", "Employee name is Blank");
			}
			return empRepository.save(emp);
//		} catch (IllegalArgumentException il) {
//			throw new ServiceException("602", "given employee is null" + il.getMessage());
//		} catch (Exception e) {
//			throw new ServiceException("603", "Something went wrong while saving employee" + e.getMessage());
//		}

	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			List<Employee> emplist = empRepository.findAll();
			if (emplist.isEmpty()) {
				throw new ServiceException("604", "List is empty");
			}
			return emplist;
		} catch (Exception e) {
			throw new ServiceException("605", "Something went wrong while fetching employee" + e.getMessage());
		}

	}

	@Override
	public Employee getEmployeeById(Long id) {

		//try {
			Employee empById = empRepository.findById(id).get();
			return empById;
	//	} catch (IllegalArgumentException e) {
		//	throw new ServiceException("606", "Given employee id is null" + e.getMessage());
	//	} catch (Exception e) {
		//	throw new ServiceException("607", "Given employee id does not exist in database" + e.getMessage());
		//}

	}

	@Override
	public Employee updateEmployee(Employee emp, Long id) {
		//try {
		Employee updateEmp = empRepository.getById(id);
		updateEmp.setEmp_name(emp.getEmp_name());
		updateEmp.setEmp_address(emp.getEmp_address());
		updateEmp.setEmp_email(emp.getEmp_email());
		updateEmp.setEmp_department(emp.getEmp_department());
		updateEmp.setEmp_salary(emp.getEmp_salary());
		return empRepository.save(updateEmp);
//		}catch (IllegalArgumentException e) {
//			throw new ServiceException("606", "Given employee id is null" + e.getMessage());
//		} catch (Exception e) {
//			throw new ServiceException("607", "Given employee id does not exist in database" + e.getMessage());
//		}
	}

	@Override
	public void deleteEmployee(Long id) {
		try {
			Employee deleteEmp = empRepository.getById(id);
			empRepository.delete(deleteEmp);;
		} catch (IllegalArgumentException e) {
			throw new ServiceException("610", "Given employee id is null" + e.getMessage());
		} catch (Exception e) {
			throw new ServiceException("611", "Given employee id does not exist in database" + e.getMessage());
		}
	}

}
