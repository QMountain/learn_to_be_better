package algorithm.leetcode.medium.m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    // 进阶为 时间 O(n);  空间 O(1) 算法是摩尔投票，可以在之前得到的结论上进一步思考：
    // 满足条件的元素最多两个，因此可以每次拿出3个来对比，全不一样，就互相抵消，最后会留下那个多的元素

    // 时间 O(n);  空间 O(n)
    public List<Integer> majorityElement(int[] nums) {
        int maxCount = nums.length / 3;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ansList = new ArrayList<>();
        for (int num : nums) {
            Integer oldCount = map.getOrDefault(num, 0);
            map.put(num,oldCount+1);
            if (oldCount+1 > maxCount) {
                ansList.add(num);
                map.put(num,-(oldCount+1)*2);
            }
        }
        return ansList;
    }

}
