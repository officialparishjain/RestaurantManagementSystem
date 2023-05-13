package com.parishjain.RestaurantManagementSystem.service;

import com.parishjain.RestaurantManagementSystem.models.Employee;
import com.parishjain.RestaurantManagementSystem.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long empId) {
      Optional<Employee> optionalEmployee =  employeeRepository.findById(empId);
      if(optionalEmployee.isPresent()) {
          return optionalEmployee.get();
      }
      else return null;
    }
}
