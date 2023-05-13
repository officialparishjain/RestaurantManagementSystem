package com.parishjain.RestaurantManagementSystem.controller;

import com.parishjain.RestaurantManagementSystem.models.Employee;
import com.parishjain.RestaurantManagementSystem.models.Food;
import com.parishjain.RestaurantManagementSystem.models.Restaurant;
import com.parishjain.RestaurantManagementSystem.service.EmployeeService;
import com.parishjain.RestaurantManagementSystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    EmployeeService employeeService;


    // SAVING RESTAURANT AND FOOD AND EMPLOYEE
    @PostMapping(value = "/add")
    public String addRestaurant(@RequestBody Restaurant restaurant){

        // First we will set food restaurant
        List<Food> foods = restaurant.getRestaurantMenu();
        // Now we will set restaurant for each food
        for(Food food : foods){
            food.setFoodRestaurant(restaurant);
        }

        List<Employee> employees = restaurant.getRestaurantEmployee();
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee: employees){
            Long empId = employee.getEmployeeId();
            Employee emp = employeeService.getEmployeeById(empId);
            employeeList.add(emp);
        }
        restaurant.setRestaurantEmployee(employeeList);
        restaurantService.saveRestaurant(restaurant);
        return "Restaurant saved successfully...";
    }

    // UPDATE RESTAURANT DETAILS
    @PutMapping (value = "/update/id/{id}/address/{address}")
    public String updateRestaurantAddress(@PathVariable Long id,@PathVariable String address){
        return restaurantService.updateAddressById(id,address);
    }


    @GetMapping(value = "/detail/{id}")
    public Restaurant getRestaurantDetail(@PathVariable Long id){
        return restaurantService.fetchDetail(id);
    }


}
