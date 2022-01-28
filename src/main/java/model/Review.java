package model;

import java.util.ArrayList;

public class Review {

    private int rating;
    private String userName;
    private ArrayList<String> dishes;
    private ArrayList<String> comments;

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", dishes=" + dishes.stream().toString() +
                ", comments=" + comments.stream().toString() +
                '}';
    }

    public Review(int rating, String userName, ArrayList<String> dishes, ArrayList<String> comments) {
        this.rating = rating;
        this.userName = userName;
        this.dishes = dishes;
        this.comments = comments;
    }

    public Review(int rating, String userName) {
        this.rating = rating;
        this.userName = userName;
        this.dishes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public int getRating() {
        return rating;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<String> getDishes() {
        return dishes;
    }

    public ArrayList<String> getComments() {
        return comments;
    }
}
