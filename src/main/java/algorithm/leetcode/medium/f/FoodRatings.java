package algorithm.leetcode.medium.f;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class FoodRatings {

    Map<String, Integer> foodRatingMap;
    Map<String, String> foodCuisineMap;
    Map<String, TreeMap<Integer, TreeSet<String>>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            String foodName = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            foodRatingMap.put(foodName, rating);
            foodCuisineMap.put(foodName, cuisine);

            TreeMap<Integer, TreeSet<String>> ratingMap = cuisineMap.getOrDefault(cuisine, new TreeMap<>());
            TreeSet<String> foodNameSet = ratingMap.getOrDefault(rating, new TreeSet<>());
            foodNameSet.add(foodName);
            ratingMap.put(rating, foodNameSet);
            cuisineMap.put(cuisine, ratingMap);
        }
    }

    public void changeRating(String food, int newRating) {
        Integer oldRating = foodRatingMap.put(food, newRating);
        String cuisine = foodCuisineMap.get(food);
        TreeMap<Integer, TreeSet<String>> ratingMap = cuisineMap.get(cuisine);
        TreeSet<String> oldSet = ratingMap.get(oldRating);
        if (oldSet.size() == 1) {
            ratingMap.remove(oldRating);
        } else {
            oldSet.remove(food);
        }
        TreeSet<String> newSet = ratingMap.getOrDefault(newRating, new TreeSet<>());
        newSet.add(food);
        ratingMap.put(newRating, newSet);
        cuisineMap.put(cuisine, ratingMap);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).lastEntry().getValue().first();
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"},
                new String[]{"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"},
                new int[]{2,6,18,6,5});
        foodRatings.changeRating("qnvseohnoe",11);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        foodRatings.changeRating("emgqdbo",3);
        foodRatings.changeRating("jmvfxjohq",9);
        foodRatings.changeRating("emgqdbo",14);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        System.out.println(foodRatings.highestRated("snaxol"));
    }
}
