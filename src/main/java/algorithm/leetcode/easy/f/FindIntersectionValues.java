package algorithm.leetcode.easy.f;

import java.util.HashSet;
import java.util.Set;

public class FindIntersectionValues {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = new int[2];
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums1) {
            if (set2.contains(i)) {
                ans[0]++;
            }
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                ans[1]++;
            }
        }
        return ans;
    }
}
