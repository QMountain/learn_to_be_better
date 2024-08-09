package algorithm.leetcode.medium.s;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SpecialPerm {

    // 2 <= nums.length <= 14
    // 1 <= nums[i] <= 10^9
    public int specialPerm(int[] nums) {
        int length = nums.length;
        if (length == 2) {
            if (nums[0] % nums[1] == 0 || nums[1] % nums[0] == 0) {
                return 2;
            }
            return 0;
        }

        int[] countArr = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                return 0;
            }
            countArr[i] = count;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < length; i++) {
            queue.add(new int[]{nums[i], countArr[i]});
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (true) {
                return 0;
            }
        }
        return specialPerm(nums, 1);
    }

    public int specialPerm(int[] nums, int lastNum) {
        int length = nums.length;
        if (length == 1) {
            if (lastNum % nums[0] == 0 || nums[0] % lastNum == 0) {
                return 1;
            }
            return 0;
        }
        int ans = 0;
        int divider = 1000_000_007;
        for (int i = 0; i < length; i++) {
            if (lastNum % nums[i] == 0 || nums[i] % lastNum == 0) {
                int[] arr = new int[length-1];
                if (i > 0) {
                    System.arraycopy(nums, 0, arr, 0, i);
                }
                if (i < length-1) {
                    System.arraycopy(nums, i+1, arr, i, length-1-i);
                }
                int v = specialPerm(arr, nums[i]);
                ans += v;
                ans %= divider;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SpecialPerm specialPerm = new SpecialPerm();
        System.out.println(2 == specialPerm.specialPerm(new int[]{1,4,3}));
        System.out.println(2 == specialPerm.specialPerm(new int[]{2, 3, 6}));
    }
}
