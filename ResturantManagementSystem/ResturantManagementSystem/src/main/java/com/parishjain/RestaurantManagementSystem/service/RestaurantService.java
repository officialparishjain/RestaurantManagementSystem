package com.parishjain.RestaurantManagementSystem.service;


import com.parishjain.RestaurantManagementSystem.models.Restaurant;
import com.parishjain.RestaurantManagementSystem.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    IRestaurantRepository restaurantRepository;
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public String updateAddressById(Long id, String address) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()){
            Restaurant restaurant =optionalRestaurant.get();
            restaurant.setRestaurantAddress(address);
            return "Updated";
        }
        else {
            return "Not Updated";
        }
    }

    public Restaurant fetchDetail(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            return restaurant;
        }
        else return null;
    }
}
