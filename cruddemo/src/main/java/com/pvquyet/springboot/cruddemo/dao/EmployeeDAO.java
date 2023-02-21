package com.pvquyet.springboot.cruddemo.dao;

import java.util.List;

import com.pvquyet.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void delete(int theId);
}
