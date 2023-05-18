package com.employeeprojesi.employeeProject.controller;

import com.employeeprojesi.employeeProject.entity.Employee;
import com.employeeprojesi.employeeProject.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/addButton")
    public String addEmployee(Model model) {
        Employee newEmp = new Employee();
        model.addAttribute("newEmployee", newEmp);

        return "employees/employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        if (!employee.getFirstName().isEmpty() || !employee.getLastName().isEmpty() || !employee.getEmail().isEmpty()) {
            employeeService.save(employee);
        } else {
            return "redirect:/employees/list";
        }

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") long id, Model model) {
        Employee themployee = employeeService.findById(id);

        model.addAttribute("newEmployee", themployee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") long id){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }


}
