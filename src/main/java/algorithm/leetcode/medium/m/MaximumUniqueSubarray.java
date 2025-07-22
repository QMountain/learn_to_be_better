package algorithm.leetcode.medium.m;

import java.util.*;

public class MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        int length = nums.length;
        int ans = nums[0];
        int sum = 0;
        int start = 0;
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (!map.containsKey(nums[j])) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.addLast(j);
                    map.put(nums[j], list);

                    sum += nums[j];
                    if (j == length - 1) {
                        ans = Math.max(ans, sum);
                        return ans;
                    }
                } else {
                    ans = Math.max(ans, sum);
                    while (nums[start] != nums[j]) {
                        LinkedList<Integer> list = map.get(nums[start]);
                        list.pollFirst();
                        if (list.isEmpty()) {
                            map.remove(nums[start]);
                        }
                        sum -= nums[start++];
                    }
                    LinkedList<Integer> list = map.get(nums[j]);
                    list.pollFirst();
                    list.addLast(j);
                    start++;
                    i = j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumUniqueSubarray maximumUniqueSubarray = new MaximumUniqueSubarray();
        System.out.println(8 == maximumUniqueSubarray.maximumUniqueSubarray(
                new int[]{5,2,1,2,5,2,1,2,5}));
        System.out.println(17 == maximumUniqueSubarray.maximumUniqueSubarray(
                new int[]{4,2,4,5,6}));
    }
}
