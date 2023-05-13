package com.parishjain.RestaurantManagementSystem.service;

import com.parishjain.RestaurantManagementSystem.repository.IFoodRepository;
import com.parishjain.RestaurantManagementSystem.repository.IRestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    IFoodRepository foodRepository;

    @Transactional
    public void updatePriceById(Long id, Double price) {
        foodRepository.updateFoodPrice(id,price);
    }
}
