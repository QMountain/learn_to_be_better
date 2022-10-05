package algorithm.leetcode.medium.a;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int length = nums.length;
        boolean[] arrived = new boolean[length];
        int max = 0;
        Set<Integer> elementSet = new HashSet<>(length);
        for (int num : nums) {
            if (!arrived[num]) {
                int nextIndex = num;
                while (true) {
                    arrived[nextIndex] = true;
                    if (!elementSet.add(nextIndex)) {
                        break;
                    }
                    nextIndex = nums[nextIndex];
                }
                max = Math.max(max, elementSet.size());
                elementSet = new HashSet<>();
            }
        }
        return max;
    }
}
