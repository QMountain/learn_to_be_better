package algorithm.leetcode.easy.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int subSum = sum/2+1;
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int checkSum = 0;
        for (int i = length-1; i >= 0; i--) {
            if (checkSum < subSum) {
                checkSum += nums[i];
                list.add(nums[i]);
            } else {
                break;
            }
        }
        return list;
    }

}
