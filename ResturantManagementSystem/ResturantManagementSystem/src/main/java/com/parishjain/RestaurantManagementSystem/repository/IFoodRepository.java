package com.parishjain.RestaurantManagementSystem.repository;

import com.parishjain.RestaurantManagementSystem.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends JpaRepository<Food, Long> {

    @Modifying
    @Query(value = "update food set food_price = :price where food_id = :id ",nativeQuery = true)
    public void updateFoodPrice(Long id, Double price);
}
