package algorithm.leetcode.easy.a;

import java.util.Arrays;

public class AnswerQueries {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int ansLength = queries.length;
        for (int i = 0; i < ansLength; i++) {
            if (queries[i] < sum[0]) {
                queries[i] = 0;
                continue;
            }
            if (queries[i] > sum[length-1]) {
                queries[i] = length;
                continue;
            }
            int index = binarySearch(queries[i], sum);
            queries[i] = index+1;
        }
        return queries;
    }

    public int binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                if (mid > left) {
                    left = mid;
                } else {
                    // left + 1 == right
                    if (arr[right] <= target) {
                        return right;
                    }
                    return left;
                }
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        AnswerQueries answerQueries = new AnswerQueries();
        System.out.println(Arrays.toString(answerQueries.answerQueries(
                new int[]{736411,184882,914641,37925,214915}, new int[]{331244,273144,118983,118252,305688,718089,665450})));
        System.out.println(Arrays.toString(answerQueries.answerQueries(
                new int[]{2,3,4,5}, new int[]{1})));
        System.out.println(Arrays.toString(answerQueries.answerQueries(
                new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
    }
}
