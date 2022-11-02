package algorithm.leetcode.medium.f;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int length = nums1.length;
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int value : nums1) {
            for (int j = 0; j < length; j++) {
                int sum = value + nums2[j];
                map1.put(sum, map1.getOrDefault(sum, 0) + 1);
            }
        }
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = nums3[i] + nums4[j];
                map2.put(sum,map2.getOrDefault(sum,0)+1);
            }
        }
        AtomicInteger ans = new AtomicInteger();
        map1.forEach((k,v)->{
            if (map2.containsKey(-k)) {
                ans.addAndGet(v * map2.get(-k));
            }
        });
        return ans.get();
    }

}
