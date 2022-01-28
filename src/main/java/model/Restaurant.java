package model;

import java.util.ArrayList;

public class Restaurant {

    private String restaurantName;
    private ArrayList<Review> restaurantReviewList;
    private int totalRating;
    private int totalRaters;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
        this.restaurantReviewList = new ArrayList<>();
        this.totalRaters = 0;
        this.totalRating = 0;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public ArrayList<Review> getRestaurantReviewList() {
        return restaurantReviewList;
    }

    public void addRestaurantReview(Review review) {
        this.restaurantReviewList.add(review);
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public void setTotalRaters(int totalRaters) {
        this.totalRaters = totalRaters;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public int getTotalRaters() {
        return totalRaters;
    }
}
