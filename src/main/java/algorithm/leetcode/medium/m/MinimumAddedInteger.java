package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MinimumAddedInteger {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = nums1.length-1;
        for (int i = nums2.length-1; i > 0; i--) {
            if (nums2[i] - nums2[i-1] == nums1[index] - nums1[index-1]) {
                index--;
            } else if (nums2[i] - nums2[i-1] < nums1[index] - nums1[index-1]) {
                index--;
                i++;
            } else {
                if (index - 1 == i) {
                    return nums2[0] - nums1[0];
                }
                if (nums2[i] - nums2[i-1] == nums1[index] - nums1[index-2]) {
                    index -= 2;
                    continue;
                }
                if (nums2[i] - nums2[i-1] == nums1[index] - nums1[index-3]) {
                    return nums2[i] - nums1[index];
                }
                if (index == nums2.length) {
                    return nums2[0] - nums1[0];
                }
                index--;
                i++;
            }
        }
        return nums2[0] - nums1[index];
    }

    public static void main(String[] args) {
        MinimumAddedInteger minimumAddedInteger = new MinimumAddedInteger();
        System.out.println(-1 == minimumAddedInteger.minimumAddedInteger(
                new int[]{7,2,6,8,7}, new int[]{7,6,5}));
        System.out.println(0 == minimumAddedInteger.minimumAddedInteger(
                new int[]{9,10,0,7,8,0}, new int[]{0,8,7,0}));
        System.out.println(-4 == minimumAddedInteger.minimumAddedInteger(
                new int[]{4,10,4,6}, new int[]{0,2}));
        System.out.println(1 == minimumAddedInteger.minimumAddedInteger(
                new int[]{8,2,2,8,7,8,1,5}, new int[]{6,9,9,2,3,9}));
        System.out.println(4 == minimumAddedInteger.minimumAddedInteger(
                new int[]{9,4,3,9,4}, new int[]{7,8,8}));

        System.out.println(0 == minimumAddedInteger.minimumAddedInteger(
                new int[]{4,6,3,1,4,2,10,9,5}, new int[]{5,10,3,2,6,1,9}));
        System.out.println(-2 == minimumAddedInteger.minimumAddedInteger(
                new int[]{4,20,16,12,8}, new int[]{14,18,10}));
    }
}
