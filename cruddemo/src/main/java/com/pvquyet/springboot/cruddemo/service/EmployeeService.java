package com.pvquyet.springboot.cruddemo.service;

import com.pvquyet.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee theEmployee);

    public void delete(int theId);
}
