package services;

import exceptions.UserNotFoundException;
import model.Restaurant;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UserService {

    private RestaurantService restaurantService;
    private HashMap<String, User> userNameToUserMap;
    private HashMap<User, HashSet<String>> userToSetOfRestaurantMap;

    public UserService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
        this.userNameToUserMap = new HashMap<>();
        this.userToSetOfRestaurantMap = new HashMap<>();
    }

    public void addUser(User user) {
        if(isUserExist(user.getUserName())) {
            System.out.println(user.getUserName() + " User Already Exists.");
        } else {
            userNameToUserMap.put(user.getUserName(), user);
        }
    }

    public void addRatingByUser(User user, String restaurantName, int rating) {
        if(!isUserExist(user.getUserName())) {
            throw new UserNotFoundException(user.getUserName() + " Not Found.");
        }
        restaurantService.addRating(user.getUserName(), restaurantName, rating);
    }

    public void addRatingByUser(User user, String restaurantName, int rating, ArrayList<String> dishes, ArrayList<String> comment) {
        if(!isUserExist(user.getUserName())) {
            throw new UserNotFoundException(user.getUserName() + " Not Found.");
        }
        restaurantService.addRating(user.getUserName(), restaurantName, rating, dishes, comment);
    }

    private boolean isUserExist(String userName) {
        return userNameToUserMap != null && userNameToUserMap.containsKey(userName);
    }

}
