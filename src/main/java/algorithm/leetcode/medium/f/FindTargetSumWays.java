package algorithm.leetcode.medium.f;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        if (nums[0] == 0) {
            map.put(0,2);
        } else {
            map.put(nums[0],1);
            map.put(-nums[0],1);
        }

        int length = nums.length;
        for (int i = 1; i < length; i++) {
            Map<Integer,Integer> nm = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                int nk1 = key + nums[i];
                Integer nv1 = nm.getOrDefault(nk1, 0);
                nm.put(nk1,nv1+value);
                int nk2 = key - nums[i];
                nm.put(nk2,nm.getOrDefault(nk2,0)+value);
            }
            map = nm;
        }
        return map.getOrDefault(target,0);
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        System.out.println(findTargetSumWays.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
        System.out.println(findTargetSumWays.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
