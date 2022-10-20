package algorithm.leetcode.medium.c;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {

    Map<Integer,Integer> map;
    int[] nums;

    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        this.map = new HashMap<>();
        return cal(target);
    }

    public int cal(int target) {
        int res = 0;
        for (int num : nums) {
            if (num == target) {
                res++;
            } else if (num < target) {
                if (map.containsKey(target-num)) {
                    res += map.get(target-num);
                } else {
                    res += cal(target-num);
                }
            }
        }
        map.put(target,res);
        return res;
    }

    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        System.out.println(combinationSum4.combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
