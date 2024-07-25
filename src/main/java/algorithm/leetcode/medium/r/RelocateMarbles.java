package algorithm.leetcode.medium.r;

import java.util.*;

public class RelocateMarbles {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int length = moveFrom.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int i = 0; i < length; i++) {
            map.put(moveFrom[i], false);
            map.put(moveTo[i], true);
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                ans.add(entry.getKey());
            }
        }
        ans.sort(Comparator.comparingInt(a -> a));
        return ans;
    }

    public List<Integer> relocateMarbles2(int[] nums, int[] moveFrom, int[] moveTo) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int length = moveFrom.length;
        for (int i = 0; i < length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> ans = new ArrayList<>(set.size());
        while (!set.isEmpty()) {
            ans.add(set.pollFirst());
        }
        return ans;
    }

}
