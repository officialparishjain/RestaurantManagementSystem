package com.parishjain.RestaurantManagementSystem.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    /*
        The reason we put CascadeType.ALL in the Restaurant class and not in the Food class is because the relationship is
        one-to-many, which means that multiple Food items can belong to a single Restaurant.

        In this case, it makes sense to define the cascading behavior on the "one" side of the relationship
        (i.e., the Restaurant class), as changes to a Restaurant entity are likely to have a cascading effect
        on its associated Food items
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "foodRestaurant",cascade = CascadeType.ALL)
    private List<Food> restaurantMenu;


    @JsonManagedReference
    @OneToMany(mappedBy = "employeeRestaurant",cascade = CascadeType.ALL)
    private List<Employee> restaurantEmployee;


}
