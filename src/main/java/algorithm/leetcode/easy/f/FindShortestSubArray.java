package algorithm.leetcode.easy.f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>(length);
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int n = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > count) {
                count = value;
                n = entry.getKey();
            }
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == count) {
                set.add(entry.getKey());
            }
        }
        int minLength = length;
        for (Integer pn : set) {
            int left = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] == pn) {
                    left = i;
                    break;
                }
            }
            int right = 0;
            for (int i = length-1; i >= 0; i--) {
                if (nums[i] == pn) {
                    right = i;
                    break;
                }
            }
            minLength = Math.min(minLength,right-left+1);
        }

        return minLength;
    }

    public static void main(String[] args) {
        FindShortestSubArray findShortestSubArray = new FindShortestSubArray();
        System.out.println(findShortestSubArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
