package controller;

import model.OrderType;
import model.OrderingFilter;
import services.RestaurantService;

public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public void addRestaurant(String restaurantName) {
        restaurantService.addRestaurant(restaurantName);
    }

    public void printResultantRestaurant(int count) {
        restaurantService.printResultantRestaurant(count);
    }

    public void printResultantRestaurantByFilter(int lowLimit, int highLimit, String orderType) {
        OrderingFilter orderingFilter = new OrderingFilter(lowLimit, highLimit, OrderType.valueOf(orderType));
        restaurantService.printResultantRestaurantByFilter(orderingFilter);
    }
}
