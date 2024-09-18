package algorithm.leetcode.medium.s;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    // 1 <= nums.length <= 2 * 10^4
    // -1000 <= nums[i] <= 1000
    // -10^7 <= k <= 10^7
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        int length = nums.length;
        int[] prefixSum = new int[length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == k) {
                res++;
            }
            for (int j = i+1; j < length; j++) {
                if (prefixSum[j]-prefixSum[i]+nums[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(4 == subarraySum.subarraySum(new int[]{1,2,1,2,1}, 3));
        System.out.println(2 == subarraySum.subarraySum(new int[]{1,2,3}, 3));
        System.out.println(2 == subarraySum.subarraySum(new int[]{1,1,1}, 2));
    }
}
