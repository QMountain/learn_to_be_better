package algorithm.leetcode.hard.s;

import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class SmallestMissingValueSubtree {

    // n == parents.length == nums.length
    // 2 <= n <= 10^5
    // 对于 i != 0 ，满足 0 <= parents[i] <= n - 1
    // parents[0] == -1
    // parents 表示一棵合法的树。
    // 1 <= nums[i] <= 10^5
    // nums[i] 互不相同
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int length = parents.length;
        HashMap<Integer, TreeSet<Integer>> vMap = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (int i = 0; i < length; i++) {
            children.add(i);
            TreeSet<Integer> set = new TreeSet<>();
            set.add(nums[i]);
            vMap.put(i, set);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(i, parents[i]);
            children.remove(parents[i]);
        }
        int[] ans = new int[length];
        while (!children.isEmpty()) {
            HashSet<Integer> nc = new HashSet<>();
            for (Integer child : children) {
                TreeSet<Integer> cv = vMap.get(child);
                Integer first = cv.first();
                if (first > 1) {
                    ans[child] = 1;
                } else {

                }
                int size = cv.size();

                Integer last = cv.last();

                Integer parent = map.get(child);
                vMap.get(parent).addAll(cv);
                nc.add(parent);
            }
            children = nc;
        }

    }

}
