package org.spring.crud.controller;

import java.util.List;

import org.spring.crud.model.Employee;
import org.spring.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public List<Employee> getEmployee() {

		List<Employee> listOfEmployee = employeeService.getAllEmployee();
		return listOfEmployee;
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		if (employee.getId() == 0) {
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}

		return employee;
	}

	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employee empl = this.employeeService.getEmployee(id);
		empl.setEmpName(employee.getEmpName());
		empl.setEmpCity(employee.getEmpCity());
		return this.employeeService.updateEmployee(empl);
	}

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);

	}
}
