package com.springboot.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee_management.entity.EmployeeEntity;
import com.springboot.employee_management.model.Employee;
import com.springboot.employee_management.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getallemployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/addemployee")
    public String addEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/updateemployee")
    public String updateEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteemployee")
    public String removeEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.removeEmployee(employee);
    }
}
