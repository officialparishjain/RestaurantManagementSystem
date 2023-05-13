package com.parishjain.RestaurantManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    private String foodName;
    private Double foodPrice;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "restaurantId")
    private Restaurant foodRestaurant;
}
