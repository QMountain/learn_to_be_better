package algorithm.leetcode.medium.f;

import java.util.HashSet;
import java.util.Set;

public class FindPairs {

    public int findPairs(int[] nums, int k) {
        int length = nums.length;
        Set<String> showed = new HashSet<>(length);
        Set<Integer> set = new HashSet<>(length);
        set.add(nums[0]);
        for (int i = 1; i < length; i++) {
            int bigger = nums[i] + k;
            if (set.contains(bigger)) {
                String s1 = nums[i] + "," + bigger;
                String s2 = bigger + "," + nums[i];
                showed.add(s1);
                showed.add(s2);
            }
            int smaller = nums[i] - k;
            if (set.contains(smaller)) {
                String s1 = nums[i] + "," + smaller;
                String s2 = smaller + "," + nums[i];
                showed.add(s1);
                showed.add(s2);
            }
            set.add(nums[i]);
        }
        if (k == 0) {
            return showed.size();
        }
        return showed.size()/2;
    }

    public static void main(String[] args) {
        FindPairs findPairs = new FindPairs();
        System.out.println(findPairs.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(findPairs.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(findPairs.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }
}
