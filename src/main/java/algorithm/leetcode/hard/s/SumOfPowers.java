package algorithm.leetcode.hard.s;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;

public class SumOfPowers {

    // 2 <= n == nums.length <= 50
    // -10^8 <= nums[i] <= 10^8
    // 2 <= k <= n
    public int sumOfPowers(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        int divider = 1000_000_007;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        /*while (true) {
            if (stack.size() < k) {
                Integer peek = stack.peek();
                int i = peek + 1;
                stack.push(i);
                int diff = nums[i] - nums[peek];
                map.put(diff, map.getOrDefault(diff, 0)+1);
            } else {
                ans += map.firstKey();
                ans %= divider;
                while (true) {
                    if (length - 1 - stack.peek() == k - stack.size()) {
                        Integer pop = stack.pop();
                        int diff = nums[pop] - nums[stack.peek()];
                        Integer old = map.get(diff);
                        if (true) {

                        }
                    }
                }
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(new int[]{pop[0]+1, 0});
                } else {

                }
            }
        }
        for (long i = 1L; i < max; i++) {
            if (Long.bitCount(i) == k) {
                String binaryString = Long.toBinaryString(i);
                int minDiff = getMinDiff(nums, binaryString, divider);
                ans += minDiff;
                ans %= divider;
            }
        }*/
        return ans;
    }

    private static int getMinDiff(int[] nums, String binaryString, int divider) {
        int bsl = binaryString.length();
        int last = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int j = bsl-1; j >= 0; j--) {
            if (binaryString.charAt(j) == '1') {
                if (last != -1) {
                    int diff = nums[bsl - 1 - j] - nums[bsl - 1 - last];
                    minDiff = Math.min(minDiff, diff);
                }
                last = j;
            }
        }
        minDiff %= divider;
        return minDiff;
    }

    public static void main(String[] args) {
        SumOfPowers sumOfPowers = new SumOfPowers();
        System.out.println(10 == sumOfPowers.sumOfPowers(new int[]{4,3,-1}, 2));
        System.out.println(0 == sumOfPowers.sumOfPowers(new int[]{2,2}, 2));
        System.out.println(4 == sumOfPowers.sumOfPowers(new int[]{1,2,3,4}, 3));
    }
}
