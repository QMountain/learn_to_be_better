package algorithm.leetcode.easy.m;

import java.util.HashSet;

public class MinNumber {

    public int minNumber(int[] nums1, int[] nums2) {
        int arr1Min = nums1[0];
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            arr1Min = Math.min(arr1Min, i);
            set1.add(i);
        }
        int bothHaveMin = -1;
        int arr2Min = nums2[0];
        for (int i : nums2) {
            arr2Min = Math.min(arr2Min, i);
            if (set1.contains(i)) {
                if (bothHaveMin == -1) {
                    bothHaveMin = i;
                } else {
                    bothHaveMin = Math.min(bothHaveMin, i);
                }
            }
        }
        if (bothHaveMin != -1) {
            return bothHaveMin;
        }
        int min = Math.min(arr1Min, arr2Min);
        return min * 10 + (arr1Min + arr2Min - min);
    }

}
