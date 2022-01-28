package factory;

import model.OrderingFilter;
import model.Restaurant;

import java.util.HashMap;

public interface RestaurantOrderingAlgorithm {
    void printResultantRestaurantList(HashMap<String, Restaurant> restaurantNameToRestaurantMap, OrderingFilter orderingFilter);
    void printTopRestaurant(HashMap<String, Restaurant> restaurantNameToRestaurantMap, int count);
}
