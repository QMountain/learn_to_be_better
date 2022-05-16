package algorithm.leetcode.medium.l;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        Set<Integer> set = new HashSet<>(length);
        for (int num : nums) {
            set.add(num);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        int maxCount = 1;
        for (int i = min; i <= max; i++) {
            int count = 1;
            for (int j = i+1; j <= max; j++) {
                if (set.contains(j)) {
                    count++;
                } else {
                    i = j-1;
                    while (!set.contains(i+1)) {
                        i++;
                    }
                    break;
                }
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }

}
