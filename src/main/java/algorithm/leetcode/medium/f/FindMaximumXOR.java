package algorithm.leetcode.medium.f;

import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int maxLength = Integer.toBinaryString(nums[0]).length();
        for (int i = 1; i < length; i++) {
            int l = Integer.toBinaryString(nums[i]).length();
            if (l > maxLength) {
                maxLength = l;
                set.clear();
                set.add(nums[i]);
            } else if (l == maxLength) {
                set.add(nums[i]);
            }
        }
        int max = 0;
        for (Integer num1 : set) {
            for (int num2 : nums) {
                int curr = num1 ^ num2;
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaximumXOR findMaximumXOR = new FindMaximumXOR();
        System.out.println(3 == findMaximumXOR.findMaximumXOR(new int[]{4,6,7}));
        System.out.println(127 == findMaximumXOR.findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
        System.out.println(28 == findMaximumXOR.findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
}
