package algorithm.leetcode.medium.m;

import java.util.HashMap;
import java.util.Map;

public class MaximumGap {

    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        int ans = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < length-1; i++) {
            int left = Math.min(nums[i], nums[i+1]);
            int right = Math.max(nums[i], nums[i+1]);

            if (map.containsKey(left)) {
                int[] arr = map.get(left);
                arr[1] = Math.min(arr[1], right);
            } else {
                int[] arr = new int[2];
                arr[0] = Integer.MIN_VALUE;
                arr[1] = right;
                map.put(left, arr);
            }

            if (map.containsKey(right)) {
                int[] arr = map.get(right);
                arr[0] = Math.max(arr[0], left);
            } else {
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = Integer.MAX_VALUE;
                map.put(right, arr);
            }
        }
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            ans = Math.min(ans, entry.getKey() - entry.getValue()[0]);
            ans = Math.min(ans, entry.getValue()[1] - entry.getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        System.out.println(3 == maximumGap.maximumGap(new int[]{3,6,9,1}));
    }
}
