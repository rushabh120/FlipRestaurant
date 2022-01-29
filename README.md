# Problem Statement
Your aim is to implement a restaurant rating system. Following are the features that it should have:
- Register: Users should be able to register to give ratings for restaurants.
- Rate: Among the pre-populated list of restaurants, registered users can give rating between 1 to 10. If the same user gives a new rating for the same restaurant, it should be overwritten.
- Rate with options: Along with a rating, users can add optional dish name(s) and rating description.
- List reviews: When fetching reviews for a restaurant based on filter and order by
- Filter: Ratings should be able to be filtered based on range of rating (eg. ratings between 4 (lower range) and 7 (higher range)). Lower range value Higher range value

# Note: 
- Filter can have lower range, higher range or both
- Order By: Order by
  - Ascending order of rating
  - Descending order of rating
- Default should be with a higher rating first without any filter.
- Describe: When describing a restaurant, along with the name, give the average rating it received so far.
- List: List restaurants based on descending order of (average) rating.

# Example
- One example present with driver class (MainDriver.java)
- addRestaurant : "restaurant1", "restaurant2", "restaurant3"
- addUser : "user1", "user2"
- addRatingByUser 
- add dishReview, comments
