package algorithm.leetcode.easy.p;

import java.util.Arrays;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int add = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == add << 1) {
                return i;
            }
            add += nums[i];
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int length = nums.length;
        int[] sumArr = new int[length];
        sumArr[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sumArr[i] = sumArr[i-1]+nums[i];
        }
        if (sumArr[length-1] - sumArr[0] == 0) {
            return 0;
        }
        int index = 1;
        while (index < length) {
            if (sumArr[index-1] == sumArr[length-1]-sumArr[index]) {
                return index;
            }
            if (index == length-1) {
                break;
            }
            index++;
        }
        if (sumArr[length-2] == 0) {
            return length-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(new int[]{-1, -1, -1, 1, 1, 1}));
        System.out.println(0 == pivotIndex.pivotIndex(new int[]{2, 1, -1}));
        System.out.println(-1 == pivotIndex.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(3 == pivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
