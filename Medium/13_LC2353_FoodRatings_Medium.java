import java.util.*;

class FoodRatings {
    Map<String, String> foodCuisine = new HashMap<>();
    Map<String, Integer> foodRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        String best = "";
        for (String food : foodCuisine.keySet()) {
            if (foodCuisine.get(food).equals(cuisine)) {
                if (best.equals("") ||
                    foodRating.get(food) > foodRating.get(best) ||
                    (foodRating.get(food).equals(foodRating.get(best)) &&
                     food.compareTo(best) < 0)) {
                    best = food;
                }
            }
        }
        return best;
    }
}
