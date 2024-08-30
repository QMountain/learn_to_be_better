package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SumDigitDifferences {

    public long sumDigitDifferences(int[] nums) {
        int length = nums.length;
        long ans = 0L;
        int n = nums[0];
        if (nums[0] % 10 == 0) {
            n++;
        }
        while (n > 0) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                int key = nums[i] % 10;
                map.put(key, map.getOrDefault(key, 0) + 1);
                nums[i] /= 10;
            }
            int sum = length;
            ArrayList<Integer> list = new ArrayList<>(map.values());
            for (int i = 0; i < list.size() - 1; i++) {
                int left = sum - list.get(i);
                ans += (long) list.get(i) * (left);
                sum = left;
            }
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        SumDigitDifferences sumDigitDifferences = new SumDigitDifferences();
        System.out.println(5 == sumDigitDifferences.sumDigitDifferences(new int[]{50, 28, 48}));
    }
}
