package algorithm.leetcode.medium.m;

import java.util.*;

public class MinimumSeconds {

    // 1 <= n == nums.length <= 10^5
    // 1 <= nums[i] <= 10^9
    public int minimumSeconds(List<Integer> nums) {
        int size = nums.size();
        // key 元素值 value 0 第一次出现的index 1 上次出现的index 2 需要多少次操作能将元素调平
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Integer key = nums.get(i);
            if (!map.containsKey(key)) {
                map.put(key, new int[]{i, i, 0});
            } else {
                int[] lastValue = map.get(key);
                int lastIndex = lastValue[1];
                int leftDistance = i - lastIndex - 1;
                int operateTimes = (leftDistance + 1) / 2;
                lastValue[2] = Math.max(lastValue[2], operateTimes);
                lastValue[1] = i;
            }
        }
        int ans = size / 2;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (value[0] == value[1]) {
                continue;
            }
            int rightDistance = size - 1 - value[1] + value[0];
            int operateTime = (rightDistance + 1) / 2;
            int max = Math.max(value[2], operateTime);
            ans = Math.min(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumSeconds minimumSeconds = new MinimumSeconds();
        int[] arr = new int[]{11,4,10};
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        System.out.println(minimumSeconds.minimumSeconds(list));
    }

}
