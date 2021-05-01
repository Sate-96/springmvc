package org.spring.crud.service;

import java.util.List;

import org.spring.crud.dao.EmployeeDao;
import org.spring.crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("countryService")
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Transactional
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
       
	}

	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
}
