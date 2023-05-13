package com.parishjain.RestaurantManagementSystem.controller;

import com.parishjain.RestaurantManagementSystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @PutMapping(value = "/updateprice/{id}/{price}")
    public String updateFoodPrice(@PathVariable Long id,@PathVariable Double price){
        foodService.updatePriceById(id,price);
        return "Updated";
    }
}
