package exceptions;

public class RestaurantNotFountException extends RuntimeException {
    public RestaurantNotFountException(String message) {
        super(message);
    }
}
