package algorithm.leetcode.medium.c;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarrays {

    /**
     * 给你一个由 正 整数组成的数组 nums 。
     * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
     * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
     * 返回数组中 完全子数组 的数目。
     * 子数组 是数组中的一个连续非空序列。
     */
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        int last = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = last+1; j < nums.length; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == set.size()) {
                    ans += nums.length - j;
                    last = j;
                    while (true) {
                        if (map.get(nums[i]) == 1) {
                            map.remove(nums[i]);
                            break;
                        } else {
                            map.put(nums[i], map.get(nums[i]) - 1);
                            i++;
                            ans += nums.length - j;
                        }
                    }
                    break;
                } else if (j == nums.length - 1) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountCompleteSubarrays countCompleteSubarrays = new CountCompleteSubarrays();
        System.out.println(10 == countCompleteSubarrays.countCompleteSubarrays(new int[]{5,5,5,5}));
        System.out.println(4 == countCompleteSubarrays.countCompleteSubarrays(new int[]{1,3,1,2,2}));
    }
}
