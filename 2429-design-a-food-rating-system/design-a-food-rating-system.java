class Pair {
  int rating;
  String food;

  public Pair(String food, int rating) {
    this.food = food;
    this.rating = rating;
  }
}

class FoodRatings {
  Map<String, PriorityQueue<Pair>> map;
  Map<String, String> foodToCuisine;
  Map<String, Integer> foodToRating;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    int n = foods.length;
    map = new HashMap<>();
    foodToCuisine = new HashMap<>();
    foodToRating = new HashMap<>();
    for (int i = 0; i < n; i++) {
      Pair p = new Pair(foods[i], ratings[i]);
      map.computeIfAbsent(cuisines[i], k -> new PriorityQueue<Pair>((a, b) ->
          a.rating == b.rating ? a.food.compareTo(b.food) : b.rating - a.rating
      )).offer(p);
      foodToCuisine.put(foods[i], cuisines[i]);
      foodToRating.put(foods[i], ratings[i]);
    }
  }

  public void changeRating(String food, int newRating) {
    String cuisine = foodToCuisine.get(food);
    int oldRating = foodToRating.get(food);
    map.get(cuisine).remove(new Pair(food, oldRating)); // Remove old pair
    Pair updatedPair = new Pair(food, newRating);
    map.get(cuisine).offer(updatedPair); // Insert updated pair
    foodToRating.put(food, newRating); // Update the rating in foodToRating
  }

  public String highestRated(String cuisine) {
    PriorityQueue<Pair> pq = map.get(cuisine);
    while (!pq.isEmpty() && foodToRating.get(pq.peek().food) != pq.peek().rating) {
      pq.poll(); // Remove outdated pairs
    }
    return pq.peek().food;
  }
}
