package algorithm.leetcode.medium.f;

import java.util.*;

public class FilterRestaurants {

    // restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]
    // 如果 rating 相同，那么按 id 从高到低排序
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        TreeMap<Integer, TreeSet<Integer>> rankMap = new TreeMap<>((a,b)-> b-a);
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] != veganFriendly) {
                continue;
            }
            if (restaurant[3] > maxPrice) {
                continue;
            }
            if (restaurant[4] > maxDistance) {
                continue;
            }
            if (rankMap.containsKey(restaurant[1])) {
                rankMap.get(restaurant[1]).add(restaurant[0]);
            } else {
                TreeSet<Integer> set = new TreeSet<>((a,b)->b-a);
                set.add(restaurant[0]);
                rankMap.put(restaurant[1], set);
            }
        }
        List<Integer> ansList = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<Integer>> entry : rankMap.entrySet()) {
            ansList.addAll(entry.getValue());
        }
        return ansList;
    }

    public static void main(String[] args) {
        FilterRestaurants filterRestaurants = new FilterRestaurants();

    }
}
