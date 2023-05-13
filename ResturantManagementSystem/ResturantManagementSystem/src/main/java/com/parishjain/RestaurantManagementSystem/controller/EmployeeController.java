package com.parishjain.RestaurantManagementSystem.controller;

import com.parishjain.RestaurantManagementSystem.models.Employee;
import com.parishjain.RestaurantManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @PostMapping(value = "/add")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "Employee has been saved successfully";
    }

}
