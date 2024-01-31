package algorithm.leetcode.easy.d;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DistinctDifferenceArray {

    public int[] distinctDifferenceArray(int[] nums) {
        int length = nums.length;
        int[] suffix = new int[length];
        HashSet<Integer> set = new HashSet<>();
        for (int i = length-1; i >= 0; i--) {
            suffix[i] = set.size();
            set.add(nums[i]);
        }
        int[] ans = new int[length];
        set.clear();
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
            ans[i] = set.size() - suffix[i];
        }
        return ans;
    }

    public int[] distinctDifferenceArray2(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
            Integer old = map.get(nums[i]);
            if (old == 1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i],old-1);
            }
            arr[i] = set.size() - map.size();
        }
        return arr;
    }

    public static void main(String[] args) {
        DistinctDifferenceArray distinctDifferenceArray = new DistinctDifferenceArray();
        System.out.println(Arrays.toString(distinctDifferenceArray.distinctDifferenceArray(
                new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(distinctDifferenceArray.distinctDifferenceArray(
                new int[]{3,2,3,4,2})));
    }
}
