package algorithm.leetcode.medium.l;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        LinkedList<LinkedList<Integer>> totalList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            totalList.add(new LinkedList<>());
        }
        int maxIndexOfTotal = 0;
        for (int i = 0; i < length; i++) {
            int maxIndex = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    maxIndex = j;
                    break;
                }
            }
            if (maxIndex == -1) {
                totalList.get(i).add(nums[i]);
                continue;
            }
            for (int j = maxIndex+1; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (totalList.get(j).size() > totalList.get(maxIndex).size()) {
                        maxIndex = j;
                    }
                }
            }
            totalList.get(i).addAll(totalList.get(maxIndex));
            totalList.get(i).add(nums[i]);
            if (totalList.get(i).size() > totalList.get(maxIndexOfTotal).size()) {
                maxIndexOfTotal = i;
            }
        }
        return totalList.get(maxIndexOfTotal);
    }

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{3,17}));
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,4,8}));
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,3}));
    }
}
