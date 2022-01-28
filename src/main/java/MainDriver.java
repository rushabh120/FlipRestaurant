import controller.RestaurantController;
import controller.UserController;
import factory.RestaurantOrderingAlgorithmFactory;
import services.RestaurantService;
import services.UserService;

import java.util.ArrayList;

public class MainDriver {

    public static void main(String[] args) {
        RestaurantService restaurantService = new
                RestaurantService(RestaurantOrderingAlgorithmFactory.getRestaurantOrderingAlgorithm("Average"));
        UserService userService = new UserService(restaurantService);

        UserController userController = new UserController(userService, restaurantService);
        RestaurantController restaurantController = new RestaurantController(restaurantService);

        restaurantController.addRestaurant("restaurant1");
        restaurantController.addRestaurant("restaurant2");
        restaurantController.addRestaurant("restaurant3");

        userController.addUser("user1");
        userController.addUser("user2");

        userController.addRatingByUser("user1", "restaurant1", 5);
        userController.addRatingByUser("user1", "restaurant2", 10);
        userController.addRatingByUser("user2", "restaurant1", 10);
        userController.addRatingByUser("user1", "restaurant3", 8);
//        userController.addRatingByUser("user2", "restaurant1", 18);

        restaurantController.printResultantRestaurant(3);

        ArrayList<String> dishesReview1 = new ArrayList<>();
        ArrayList<String> commentsReview1 = new ArrayList<>();
        ArrayList<String> dishesReview2 = new ArrayList<>();
        ArrayList<String> commentsReview2 = new ArrayList<>();

        dishesReview1.add("samosa");
        dishesReview1.add("tea");
        commentsReview1.add("Samosa and tea were good");
        userController.addRatingByUser("user2", "restaurant1", 18, dishesReview1, commentsReview1);
        dishesReview2.add("dosa");
        commentsReview2.add("Dosa was awesome");

    }
}
