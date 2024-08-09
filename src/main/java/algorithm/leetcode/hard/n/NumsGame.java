package algorithm.leetcode.hard.n;

import java.util.*;

public class NumsGame {

    public int[] numsGame(int[] nums) {
        // key 每段的start   value 0 end 1 系数 2 常数
        TreeMap<Integer, int[]> segmentMap = new TreeMap<>();
        segmentMap.put(Integer.MIN_VALUE, new int[]{nums[0], -1, nums[0]});
        segmentMap.put(nums[0], new int[]{Integer.MAX_VALUE, 1, -nums[0]});
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 1; i < length; i++) {
            int key = nums[i] - i;
            if (segmentMap.containsKey(key)) {
                int[] value = segmentMap.get(key);
                value[1]++;
                int v = calEntry(key, value);
                ans[i] = Math.min(ans[i-1], v);
            } else {
                Map.Entry<Integer, int[]> lowerEntry = segmentMap.lowerEntry(key);
                int[] lowerValue = lowerEntry.getValue();
                int[] nValue = {lowerValue[0], lowerValue[1] + 1, lowerValue[2] - key};
                segmentMap.put(key, nValue);
                int v1 = calEntry(key, nValue);

                lowerValue[0] = nums[i];
                lowerValue[1]--;
                lowerValue[2] += nums[i];
                int v2 = calEntry(lowerEntry.getKey(), lowerValue);
                ans[i] = Math.min(ans[i-1], Math.min(v1, v2));
            }
        }

        return ans;
    }

    public int calEntry(int key, int[] value) {
        int xs = value[1];
        if (xs < 0) {
            return value[2] + (value[0] * xs);
        }
        return value[2] + (key * xs);
    }

    public static void main(String[] args) {
        NumsGame numsGame = new NumsGame();
        System.out.println(Arrays.toString(numsGame.numsGame(new int[]{3, 4, 5, 1, 6, 7})));
        System.out.println(Arrays.toString(numsGame.numsGame(new int[]{1,1,1,2,3,4})));
        System.out.println(Arrays.toString(numsGame.numsGame(new int[]{1,2,3,4,5})));

    }
}
