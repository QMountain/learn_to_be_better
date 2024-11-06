package algorithm.leetcode.medium.r;

import java.util.Arrays;
import java.util.LinkedList;

public class ResultsArray {

    public int[] resultsArray(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length-k+1];
        int segStart = 0;
        for (int i = 1; i < k-1; i++) {
            if (nums[i] != nums[i-1] + 1) {
                segStart = i;
            }
        }
        for (int i = k-1; i < length; i++) {
            if (k == 1) {
                ans[i - k + 1] = nums[i];
                continue;
            }
            if (nums[i] != nums[i-1] + 1) {
                segStart = i;
            }
            if (i - segStart >= k - 1) {
                ans[i - k + 1] = nums[i];
            } else {
                ans[i - k + 1] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ResultsArray resultsArray = new ResultsArray();
        System.out.println(Arrays.toString(resultsArray.resultsArray(
                new int[]{1}, 1)));
        System.out.println(Arrays.toString(resultsArray.resultsArray(
                new int[]{3,2,3,2,3,2}, 2)));
        System.out.println("[-1, -1]".equals(Arrays.toString(resultsArray.resultsArray(
                new int[]{2,2,2,2,2}, 4))));

        System.out.println("[3, 4, -1, -1, -1]".equals(Arrays.toString(resultsArray.resultsArray(
                new int[]{1,2,3,4,3,2,5}, 3))));
    }
}
