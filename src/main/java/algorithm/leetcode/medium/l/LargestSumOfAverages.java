package algorithm.leetcode.medium.l;

import java.util.HashMap;
import java.util.Map;

public class LargestSumOfAverages {

    int length;
    int[] prefixSum;
    Map<String, Double> map;

    // 1 <= nums.length <= 100
    // 1 <= nums[i] <= 10^4
    // 1 <= k <= nums.length
    public double largestSumOfAverages(int[] nums, int k) {
        length = nums.length;
        prefixSum = new int[length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        if (k == 1) {
            return (double) prefixSum[length - 1] / length;
        }
        map = new HashMap<>();
        double ans = 0.0d;
        for (int i = 0; i <= length - k; i++) {
            double p1 = (double) prefixSum[i] / (i + 1);
            double p2 = fromIndex(i+1, k-1);
            ans = Math.max(p1+p2, ans);
        }
        return ans;
    }

    public double fromIndex(int index, int k) {
        String key = index + "," + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (k == 1) {
            return (prefixSum[length - 1] - prefixSum[index - 1]) / (double) (length - index);
        } else if (k == length - index) {
            return prefixSum[length - 1] - prefixSum[index - 1];
        }
        double res = 0.0d;
        for (int i = index; i <= length-k; i++) {
            double p1 = (prefixSum[i] - prefixSum[index - 1]) / (double) (i - index + 1);
            double p2 = fromIndex(i+1, k-1);
            res = Math.max(p1+p2, res);
        }
        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
        System.out.println(largestSumOfAverages.largestSumOfAverages(
                new int[]{1,2,3,4,5,6,7}, 4));
        System.out.println(largestSumOfAverages.largestSumOfAverages(
                new int[]{9,1,2,3,9}, 3));
    }
}
