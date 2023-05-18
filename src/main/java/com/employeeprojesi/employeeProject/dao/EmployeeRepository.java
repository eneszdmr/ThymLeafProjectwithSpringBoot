package com.employeeprojesi.employeeProject.dao;

import com.employeeprojesi.employeeProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public List<Employee> findAllByOrderByFirstNameAsc();
}
