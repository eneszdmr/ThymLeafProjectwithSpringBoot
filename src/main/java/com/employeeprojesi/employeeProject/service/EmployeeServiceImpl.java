package com.employeeprojesi.employeeProject.service;

import com.employeeprojesi.employeeProject.dao.EmployeeRepository;
import com.employeeprojesi.employeeProject.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);

    }
}
