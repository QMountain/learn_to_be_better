package algorithm.leetcode.hard.r;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ResultArray {

    // 3 <= n <= 10^5
    // 1 <= nums[i] <= 10^9
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>(n);
        arr1.add(nums[0]);
        ArrayList<Integer> arr2 = new ArrayList<>(n);
        arr2.add(nums[1]);
        LinkedList<Integer> originArr1 = new LinkedList<>();
        originArr1.addLast(nums[0]);
        LinkedList<Integer> originArr2 = new LinkedList<>();
        originArr2.addLast(nums[1]);
        for (int i = 2; i < n; i++) {
            int search1 = search(arr1, 0, arr1.size()-1, nums[i]);
            int search2 = search(arr2, 0, search1, nums[i]);
            int count1 = arr1.size() - search1;
            int count2 = arr2.size() - search2;
            if (count1 > count2) {
                originArr1.addLast(nums[i]);
                arr1.add(search1, nums[i]);
            } else if (count1 < count2) {
                originArr2.addLast(nums[i]);
                arr2.add(search2, nums[i]);
            } else {
                if (arr1.size() > arr2.size()) {
                    originArr2.addLast(nums[i]);
                    arr2.add(search2, nums[i]);
                } else {
                    originArr1.addLast(nums[i]);
                    arr1.add(search1, nums[i]);
                }
            }
        }
        int index = 0;
        for (Integer i : originArr1) {
            nums[index++] = i;
        }
        for (Integer i : originArr2) {
            nums[index++] = i;
        }
        return nums;
    }

    public int search(ArrayList<Integer> list, int left, int right, int target) {
        if (list.get(left) <= target) {
            return 0;
        }
        if (list.get(right) > target) {
            return Integer.MAX_VALUE;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) <= target) {
                right = mid;
            } else {
                if (left == mid) {
                    if (list.get(right) > target) {
                        return right;
                    }
                    return left;
                }
                right = left;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        ResultArray resultArray = new ResultArray();
        System.out.println(Arrays.toString(resultArray.resultArray(
                new int[]{44,94,96,81,91,51,32,91,8,41})));
        System.out.println(Arrays.toString(resultArray.resultArray(
                new int[]{5,14,3,1,2})));
        System.out.println(Arrays.toString(resultArray.resultArray(
                new int[]{2,1,3,3})));
    }
}
