package com.pvquyet.springboot.cruddemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import com.pvquyet.springboot.cruddemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvquyet.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	// quick and drity: inject employee dao
	@Autowired
	public EmployeeRestController(@Qualifier("employeeServiceImplRepository") EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// expose "/employee" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeErrorException(null, "Employee id not found - " + employeeId);
		}

		return employee;
	}

	// add mapping for POST /employees add new employee
	@PostMapping("/employees")
	public String insert(@RequestBody Employee theEmployee) {
		
		// also just in case they pas an id in json ... set id to 0
		// this is force a save new item ... instead of update
		
		theEmployee.setId(0);
		Integer employeeId = employeeService.save(theEmployee);
		return "Add new employee success with Identify " + employeeId;
	}
	
	// add mapping for PUT /employees update existing employee 
	@PutMapping("/employees")
	public String update(@RequestBody Employee theEmployee) {
		
		// check employeeId existing
		int employeeId = theEmployee.getId();
		if(employeeService.findById(employeeId) == null) {
			throw new RuntimeErrorException(null, "Employee id not found - " + employeeId);
		}
		
		employeeService.save(theEmployee);
		return "Update employee success with Identify " + employeeId;
	}
	
	// add mapping for DELETE /employees/{employeeId}
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeErrorException(null, "Employee id not found - " + employeeId);
		}
		employeeService.delete(employeeId);
		return "Deleted employee id " + employeeId;
	}
}
