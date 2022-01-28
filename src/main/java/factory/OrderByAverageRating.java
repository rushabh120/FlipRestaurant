package factory;

import model.OrderingFilter;
import model.Restaurant;
import model.Review;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class OrderByAverageRating implements RestaurantOrderingAlgorithm {

    Queue<Restaurant> restaurantPriorityQueue = new PriorityQueue<Restaurant>(new HigherRatingComparator());

    @Override
    public void printResultantRestaurantList(HashMap<String, Restaurant> restaurantNameToRestaurantMap, OrderingFilter orderingFilter) {

    }

    @Override
    public void printTopRestaurant(HashMap<String, Restaurant> restaurantNameToRestaurantMap, int count) {
        restaurantPriorityQueue.addAll(restaurantNameToRestaurantMap.values());
        while(!restaurantPriorityQueue.isEmpty() && count-- > 0) {
            Restaurant restaurant = restaurantPriorityQueue.poll();
            double avgRating = (restaurant.getTotalRating() * 1.0) / restaurant.getTotalRaters();
            System.out.println(restaurant.getRestaurantName() + " Average Rating = " + avgRating );
            for(Review review : restaurant.getRestaurantReviewList()) {
                for(String dishes : review.getDishes()) {
                    System.out.println(dishes);
                }
                for(String dishes : review.getComments()) {
                    System.out.println(dishes);
                }
            }
        }
    }
}

class HigherRatingComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        double avgRating1 = (o1.getTotalRating() * 1.0) / o1.getTotalRaters();
        double avgRating2 = (o2.getTotalRating() * 1.0) / o2.getTotalRaters();
        return avgRating1 < avgRating2 ? 1 : -1;
    }

}
