package algorithm.leetcode.easy.m;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer oldCount = map.getOrDefault(num, 0);
            if (oldCount == length/2) {
                return num;
            } else {
                map.put(num,oldCount+1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(3 == majorityElement.majorityElement(new int[]{3,2,3}));
        System.out.println(2 == majorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }


}
