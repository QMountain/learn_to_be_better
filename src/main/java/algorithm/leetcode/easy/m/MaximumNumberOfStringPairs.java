package algorithm.leetcode.easy.m;

import java.util.HashMap;

public class MaximumNumberOfStringPairs {

    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String reverse = word.charAt(1) + "" + word.charAt(0);
            if (map.containsKey(reverse) && map.get(reverse) == 1) {
                ans += 1;
                map.put(reverse, 0);
            } else {
                map.put(word, 1);
            }
        }
        return ans;
    }

}
