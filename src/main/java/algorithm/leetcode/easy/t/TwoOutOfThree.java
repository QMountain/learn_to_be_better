package algorithm.leetcode.easy.t;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoOutOfThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums3) {
            set3.add(i);
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : set1) {
            if (set2.contains(i) || set3.contains(i)) {
                set.add(i);
            }
        }
        for (Integer i : set2) {
            if (set1.contains(i) || set3.contains(i)) {
                set.add(i);
            }
        }
        for (Integer i : set3) {
            if (set1.contains(i) || set2.contains(i)) {
                set.add(i);
            }
        }
        return new ArrayList<>(set);
    }

}
