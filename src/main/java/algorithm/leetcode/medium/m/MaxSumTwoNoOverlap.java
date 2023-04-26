package algorithm.leetcode.medium.m;

public class MaxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int length = nums.length;
        int minLen = Math.min(firstLen, secondLen);
        int maxLen = Math.max(firstLen, secondLen);
        firstLen = minLen;
        secondLen = maxLen;
        // 正序统计
        int[][] fromLeftArr = new int[length][2];
        int firstSum = nums[0];
        for (int i = 1; i < minLen; i++) {
            firstSum += nums[i];
        }
        fromLeftArr[firstLen-1][0] = firstSum;
        int secondSum = firstSum;
        for (int i = minLen; i < maxLen; i++) {
            firstSum -= nums[i - firstLen];
            firstSum += nums[i];
            fromLeftArr[i][0] = Math.max(firstSum, fromLeftArr[i - 1][0]);
            secondSum += nums[i];
        }
        fromLeftArr[maxLen-1][1] = secondSum;
        int fromIndex = maxLen;
        for (int i = fromIndex; i < length; i++) {
            firstSum -= nums[i - firstLen];
            firstSum += nums[i];
            fromLeftArr[i][0] = Math.max(firstSum, fromLeftArr[i - 1][0]);
            secondSum -= nums[i - secondLen];
            secondSum += nums[i];
            fromLeftArr[i][1] = Math.max(secondSum, fromLeftArr[i - 1][1]);
        }

        // 倒序统计
        int[][] fromRightArr = new int[length][2];
        firstSum = nums[length-1];
        for (int i = 1; i < minLen; i++) {
            firstSum += nums[length-1-i];
        }
        fromRightArr[length-firstLen][0] = firstSum;
        secondSum = firstSum;
        for (int i = minLen; i < maxLen; i++) {
            firstSum -= nums[length - i - 1 + firstLen];
            firstSum += nums[length - i - 1];
            fromRightArr[length - i - 1][0] = Math.max(firstSum, fromRightArr[length - i][0]);
            secondSum += nums[length - i - 1];
        }
        fromRightArr[length-maxLen][1] = secondSum;
        fromIndex = length - secondLen;
        for (int i = fromIndex-1; i >= 0; i--) {
            firstSum -= nums[i + firstLen];
            firstSum += nums[i];
            fromRightArr[i][0] = Math.max(firstSum, fromRightArr[i + 1][0]);
            secondSum -= nums[i + secondLen];
            secondSum += nums[i];
            fromRightArr[i][1] = Math.max(secondSum, fromRightArr[i + 1][1]);
        }

        int max = 0;
        for (int i = length-minLen; i >= minLen; i--) {
            if (length - i >= minLen) {
                max = Math.max(max, fromLeftArr[i-1][0] + fromRightArr[i][1]);
            }
            max = Math.max(max, fromLeftArr[i-1][1] + fromRightArr[i][0]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumTwoNoOverlap maxSumTwoNoOverlap = new MaxSumTwoNoOverlap();
        System.out.println(maxSumTwoNoOverlap.maxSumTwoNoOverlap(
                new int[]{17,8,10,6,4,10,5,18,18,5,15,15,14,0,12,11,18}, 9, 3));
        System.out.println(maxSumTwoNoOverlap.maxSumTwoNoOverlap(
                new int[]{8,20,6,2,20,17,6,3,20,8,12}, 5, 4));
        System.out.println(maxSumTwoNoOverlap.maxSumTwoNoOverlap(
                new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
        System.out.println(maxSumTwoNoOverlap.maxSumTwoNoOverlap(
                new int[]{3,8,1,3,2,1,8,9,0}, 3, 2));
        System.out.println(maxSumTwoNoOverlap.maxSumTwoNoOverlap(
                new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
    }
}
