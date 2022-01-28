package services;

import exceptions.RestaurantNotFountException;
import factory.RestaurantOrderingAlgorithm;
import model.OrderingFilter;
import model.Restaurant;
import model.Review;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantService {

    private RestaurantOrderingAlgorithm restaurantOrderingAlgorithm;
    private HashMap<String, Restaurant> restaurantNameToRestaurantMap;

    public RestaurantService(RestaurantOrderingAlgorithm restaurantOrderingAlgorithm) {
        this.restaurantOrderingAlgorithm = restaurantOrderingAlgorithm;
        this.restaurantNameToRestaurantMap = new HashMap<>();
    }

    public void addRestaurant(String restaurantName) {
        if(isRestaurantExist(restaurantName)) {
            System.out.println(restaurantName + " Restaurant Already Exist.");
        } else {
            Restaurant restaurant = new Restaurant(restaurantName);
            restaurantNameToRestaurantMap.put(restaurantName, restaurant);
        }
    }

    public void addRating(String userName, String restaurantName, int rating) {
        if(!isRestaurantExist(restaurantName)) {
            throw new RestaurantNotFountException(restaurantName + " Not Found.");
        }
        Restaurant restaurant = getRestaurant(restaurantName);
        Review review = getReviewObject(rating, userName);
        addRatingForRestaurant(restaurant, review, userName);
    }

    public void addRating(String userName, String restaurantName, int rating, ArrayList<String> dishes, ArrayList<String> comment) {
        if(!isRestaurantExist(restaurantName)) {
            throw new RestaurantNotFountException(restaurantName + " Not Found.");
        }
        Restaurant restaurant = getRestaurant(restaurantName);
        Review review = getReviewObject(rating, userName, dishes, comment);
        addRatingForRestaurant(restaurant, review, userName);
    }

    private void addRatingForRestaurant(Restaurant restaurant, Review review, String userName) {
        ArrayList<Integer> indexAndRating = getUserReviewIndexAndRating(userName, restaurant);
        int totalRating = restaurant.getTotalRating();
        int totalRaters = restaurant.getTotalRaters();
        if(indexAndRating.size() != 0) {
            restaurant.setTotalRating(totalRating - indexAndRating.get(1));
            restaurant.setTotalRating(totalRaters - 1);
            restaurant.getRestaurantReviewList().remove(indexAndRating.get(0).intValue());
            totalRating -= indexAndRating.get(1);
            totalRaters -= 1;
        }
        restaurant.getRestaurantReviewList().add(review);
        restaurant.setTotalRating(totalRating + review.getRating());
        restaurant.setTotalRaters(totalRaters + 1);
    }

    public void printResultantRestaurant(int count) {
        restaurantOrderingAlgorithm.printTopRestaurant(restaurantNameToRestaurantMap, count);
    }

    public void printResultantRestaurantByFilter(OrderingFilter orderingFilter) {
        restaurantOrderingAlgorithm.printResultantRestaurantList(restaurantNameToRestaurantMap, orderingFilter);
    }

    private boolean isRestaurantExist(String restaurantName) {
        return restaurantNameToRestaurantMap != null && restaurantNameToRestaurantMap.containsKey(restaurantName);
    }

    private Restaurant getRestaurant(String restaurantName) {
        return restaurantNameToRestaurantMap.get(restaurantName);
    }
    private ArrayList<Integer> getUserReviewIndexAndRating(String userName, Restaurant restaurant) {
        ArrayList<Integer> indexAndRating = new ArrayList<>();
        for(Review review : restaurant.getRestaurantReviewList()) {
            if(review.getUserName().equals(userName)) {
                indexAndRating.add(restaurant.getRestaurantReviewList().indexOf(review));
                indexAndRating.add(review.getRating());
                break;
            }
        }
        return indexAndRating;
    }

    private Review getReviewObject(int rating, String userName) {
        return new Review(rating, userName);
    }

    private Review getReviewObject(int rating, String userName, ArrayList<String> dishes, ArrayList<String> comment) {
        return new Review(rating, userName, dishes, comment);
    }

    public void setRestaurantOrderingAlgorithm(RestaurantOrderingAlgorithm restaurantOrderingAlgorithm) {
        this.restaurantOrderingAlgorithm = restaurantOrderingAlgorithm;
    }
}
