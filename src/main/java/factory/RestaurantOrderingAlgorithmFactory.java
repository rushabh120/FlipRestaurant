package factory;

public class RestaurantOrderingAlgorithmFactory {

    public static RestaurantOrderingAlgorithm getRestaurantOrderingAlgorithm(String algorithmKey) {
        if(algorithmKey.equalsIgnoreCase("AVERAGE")) {
            return new OrderByAverageRating();
        }
        // TODO : Add more algorithms as per ordering requirement 
        return null;
    }
}
