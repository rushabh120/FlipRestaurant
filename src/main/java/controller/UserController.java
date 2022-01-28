package controller;

import exceptions.UserNotFoundException;
import model.User;
import services.RestaurantService;
import services.UserService;

import java.util.ArrayList;

public class UserController {

    private UserService userService;
    private RestaurantService restaurantService;

    public UserController(UserService userService, RestaurantService restaurantService) {
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    public void addUser(String userName) {
        User user = new User(userName);
        userService.addUser(user);
    }

    public void addRatingByUser(String userName, String restaurantName, int rating) {
        User user = new User(userName);
        userService.addRatingByUser(user, restaurantName, rating);
    }

    public void addRatingByUser(String userName, String restaurantName, int rating, ArrayList<String> dishes, ArrayList<String> comment) {
        User user = new User(userName);
        userService.addRatingByUser(user, restaurantName, rating, dishes, comment);
    }
}
