package algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class FindFinalValue {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        while (true) {
            if (set.contains(original)) {
                original *= 2;
            } else {
                break;
            }
        }
        return original;
    }

}
