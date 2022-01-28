package factory;

public class RestaurantOrderingAlgorithmFactory {

    public static RestaurantOrderingAlgorithm getRestaurantOrderingAlgorithm(String algorithmKey) {
        if(algorithmKey.equalsIgnoreCase("AVERAGE")) {
            return new OrderByAverageRating();
        }
        return null;
    }
}
