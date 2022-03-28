package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(nums1.length);
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>(nums2.length);
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        set2.retainAll(set1);
        int[] arr = new int[set1.size()];
        int i = 0;
        for (Integer n : set1) {
            arr[i] = n;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        System.out.println(Arrays.toString(intersection.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
