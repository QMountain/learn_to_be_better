package algorithm.leetcode.medium.a;

import java.util.HashMap;
import java.util.Map;

public class ArrayChange {

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i],i);
        }
        for (int[] operation : operations) {
            int oldV = operation[0];
            int newV = operation[1];
            Integer index = map.get(oldV);
            nums[index] = newV;
            map.put(newV,index);
        }
        return nums;
    }

}
