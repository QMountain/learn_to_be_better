package algorithm.leetcode.easy.t;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndices {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left+right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                if (left == mid) {
                    left++;
                } else {
                    left = mid;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        if (nums[left] != target) {
            return list;
        }
        for (int i = left; i < length; i++) {
            if (nums[i] == target) {
                list.add(i);
            } else {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TargetIndices targetIndices = new TargetIndices();
        System.out.println(targetIndices.targetIndices(new int[]{1,2,5,2,3}, 4));
        System.out.println(targetIndices.targetIndices(new int[]{1,2,5,2,3}, 5));
        System.out.println(targetIndices.targetIndices(new int[]{1,2,5,2,3}, 3));
        System.out.println(targetIndices.targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
    }
}
