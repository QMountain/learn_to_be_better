package algorithm.leetcode.hard.c;

import java.util.*;

public class CountSmaller {

    // 1 <= nums.length <= 10的5次方
    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        List<Integer> ansList = new LinkedList<>();
        ansList.add(0);
        List<Integer> list = new ArrayList<>(length);
        list.add(nums[length-1]);
        for (int i = length-2; i >= 0; i--) {
            int index = binarySearch(list, nums[i]);
            ansList.add(0,index);
            list.add(index,nums[i]);
        }
        return ansList;
    }

    public int binarySearch(List<Integer> array, int target) {
        int min = array.get(0);
        if (target <= min) {
            return 0;
        }
        int length = array.size();
        int max = array.get(length-1);
        if (target > max) {
            return length;
        }
        int left = 0;
        int right = length -1;
        while (left < right) {
            int mid = (left+right) >> 1;
            int n = array.get(mid);
            if (n >= target) {
                right = mid;
            } else {
                if (mid == left) {
                    left++;
                } else {
                    left = mid;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        System.out.println(countSmaller.countSmaller(new int[]{5,2,6,1}));
        System.out.println(countSmaller.countSmaller(new int[]{1,9,7,8,5}));
        System.out.println(countSmaller.countSmaller(new int[]{2,0,1}));
        System.out.println(countSmaller.countSmaller(new int[]{-1,-1}));
        System.out.println(countSmaller.countSmaller(new int[]{-1}));

    }
}
