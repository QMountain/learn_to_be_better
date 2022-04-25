package algorithm.leetcode.easy.m;

import java.util.Arrays;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int putIndex = nums1.length-1;
        int maxIndex1 = m-1;
        int maxIndex2 = n-1;
        while (maxIndex1 >= 0 || maxIndex2 >= 0) {
            if (maxIndex1 < 0) {
                nums1[putIndex] = nums2[maxIndex2];
                maxIndex2--;
            } else if (maxIndex2 < 0) {
                nums1[putIndex] = nums1[maxIndex1];
                maxIndex1--;
            } else if (nums1[maxIndex1] > nums2[maxIndex2]) {
                nums1[putIndex] = nums1[maxIndex1];
                maxIndex1--;
            } else {
                nums1[putIndex] = nums2[maxIndex2];
                maxIndex2--;
            }
            putIndex--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        merge.merge(new int[]{1},1,new int[]{},0);
        merge.merge(new int[]{0},0,new int[]{1},1);
    }
}
