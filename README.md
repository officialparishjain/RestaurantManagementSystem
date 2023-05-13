# Project Name
Restaurant Management System

# Frameworks and Language Used
**Spring Boot** 2.1.0
**Java** 20.0
**Maven** 3.8.1

# Data Flow
The following functions are used in the data flow of this project:

_**Models:**_ 

"Employee" class:

Contains properties for an employee, including an employee ID, name, role, and salary.
Includes a many-to-one relationship with the "Restaurant" entity using the @ManyToOne annotation.
Uses the @JsonBackReference annotation to handle bidirectional relationship with the "Restaurant" entity, preventing infinite recursion during serialization.

"Food" class:

Contains properties for a food item, including a food ID, name, and price.
Includes a many-to-one relationship with the "Restaurant" entity using the @ManyToOne annotation.
Uses the @JsonBackReference annotation to handle bidirectional relationship with the "Restaurant" entity, preventing infinite recursion during serialization.
Uses @JoinColumn annotation to specify the foreign key column name "restaurantId" in the "Food" table that references the primary key column of the "Restaurant" table.

"Restaurant" class:

Contains properties for a restaurant, including a restaurant ID, name, and address.
Includes a one-to-many relationship with the "Food" entity using the @OneToMany annotation.
Uses the mappedBy attribute to specify the inverse side of the relationship (i.e., the "Food" entity).
Uses the @JsonManagedReference annotation to handle bidirectional relationship with the "Food" entity, preventing infinite recursion during serialization.
Includes a one-to-many relationship with the "Employee" entity using the @OneToMany annotation.
Uses the mappedBy attribute to specify the inverse side of the relationship (i.e., the "Employee" entity).
Uses the @JsonManagedReference annotation to handle bidirectional relationship with the "Employee" entity, preventing infinite recursion during serialization.
Uses the CascadeType.ALL option to specify that any changes made to a "Restaurant" entity should be propagated to its associated "Food" and "Employee" entities.


_**Controller:**_ 


The code provided includes three different controller classes: EmployeeController, FoodController, and RestaurantController.

The EmployeeController class has an addEmployee() method that receives an Employee object as a request body and passes it to an EmployeeService instance to save it to the database.

The FoodController class has an updateFoodPrice() method that receives a food ID and a new price as path variables and passes them to a FoodService instance to update the price of the food item with the corresponding ID.

The RestaurantController class has several methods. The addRestaurant() method receives a Restaurant object as a request body, sets the restaurant for each food item in the restaurant menu, retrieves the Employee objects associated with the restaurant and sets them in the restaurant object, and then passes the restaurant object to a RestaurantService instance to save it to the database. The updateRestaurantAddress() method receives a restaurant ID and a new address as path variables and passes them to a RestaurantService instance to update the address of the restaurant with the corresponding ID. The getRestaurantDetail() method receives a restaurant ID as a path variable and returns the details of the restaurant with the corresponding ID.


_**Services**:_ 

The code consists of three service classes - EmployeeService, FoodService, and RestaurantService - that provide methods for performing CRUD operations on Employee, Food, and Restaurant entities respectively.

EmployeeService has methods to save and retrieve Employee entities by their ID.

FoodService has a method to update the price of a food item by its ID.

RestaurantService has methods to save a Restaurant entity, update its address by ID, and fetch details of a Restaurant entity by its ID.

All three services make use of their respective repositories (IEmployeeRepository, IFoodRepository, and IRestaurantRepository) to perform database operations. Additionally, the RestaurantService class also uses the EmployeeService to retrieve and set the employees associated with a Restaurant entity.


_**Repository:**_ The repository layer is responsible for interacting with the database. It uses Spring Data JPA to perform CRUD (create, read, update, delete) operations on entities.


# Database Structure Used
I have used MySql as Database.

# Project Summary

This is an ecommerce application that allow user to place order and having differnt fetures also



