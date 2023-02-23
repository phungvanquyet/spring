package com.pvquyet.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvquyet.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// that's it .. no need write any code
}
