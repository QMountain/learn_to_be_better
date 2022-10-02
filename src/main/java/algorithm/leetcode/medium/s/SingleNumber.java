package algorithm.leetcode.medium.s;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    // 题号 260 只出现一次的数字 III
    public int[] singleNumber3(int[] nums) {
        int xor = 0;
        for (int j : nums) {
            xor ^= j;
        }
        int lbs = xor & (-xor);
        int n1 = 0;
        int n2 = 0;
        for (int num : nums) {
            if ((num & lbs) == 0) {
                n1 ^= num;
            } else {
                n2 ^= num;
            }
        }
        return new int[]{n1,n2};
    }

    // 时间O(logN) 没用额外空间
    public int singleNumber(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[length-1] != nums[length-2]) {
            return nums[length-1];
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return 0;
    }

    // 用了额外空间,时间 O(N)
    public int singleNumber2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(Arrays.toString(singleNumber.singleNumber3(new int[]{1,2,1,3,2,5})));
        System.out.println(Arrays.toString(singleNumber.singleNumber3(new int[]{-1,0})));
    }
}
