package algorithm.leetcode.medium.f;

import java.util.*;

public class FindClosest {

    public Map<String, List<Integer>> map;

    public int findClosest(String[] words, String word1, String word2) {
        map = new HashMap<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            List<Integer> list = new ArrayList<>(map.getOrDefault(word,new ArrayList<>()));
            list.add(i);
            map.put(word,list);
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int minDistance = length;
        for (Integer index1 : list1) {
            for (Integer index2 : list2) {
                if (index2 > index1 && index2 - index1 >= minDistance) {
                    break;
                }
                minDistance = Math.min(minDistance, Math.abs(index2 - index1));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        FindClosest findClosest = new FindClosest();
        System.out.println(findClosest.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }
}
