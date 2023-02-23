package com.pvquyet.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import com.pvquyet.springboot.cruddemo.dao.EmployeeRepository;
import com.pvquyet.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplRepository implements EmployeeService {
		
	private EmployeeRepository employeeDAO;

	
	@Autowired
	public EmployeeServiceImplRepository(EmployeeRepository employeeRepository) {
		this.employeeDAO = employeeRepository;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		Optional<Employee> result = employeeDAO.findById(id);
		return result.get();
	}

	@Override
	@Transactional
	public Integer save(Employee theEmployee) {
		Employee result =  employeeDAO.save(theEmployee);
		return result.getId();
	}

	@Override
	@Transactional
	public void delete(int theId) {
		employeeDAO.deleteById(theId);
	}

}
