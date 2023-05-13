package com.parishjain.RestaurantManagementSystem.repository;

import com.parishjain.RestaurantManagementSystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
