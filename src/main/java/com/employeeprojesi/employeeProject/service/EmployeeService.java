package com.employeeprojesi.employeeProject.service;

import com.employeeprojesi.employeeProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(long id);

    public void save (Employee employee);

    public void deleteById(long id);
}
