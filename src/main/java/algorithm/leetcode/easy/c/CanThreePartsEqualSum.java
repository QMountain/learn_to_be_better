package algorithm.leetcode.easy.c;

import java.util.Arrays;

public class CanThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return false;
        }
        boolean one = false;
        int add = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            add += arr[i];
            if (!one && add == sum/3) {
                one = true;
            } else {
                if (one && add == sum/3*2 && i < length-1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanThreePartsEqualSum canThreePartsEqualSum = new CanThreePartsEqualSum();
        System.out.println(canThreePartsEqualSum.canThreePartsEqualSum(
                new int[]{1,-1,1,-1}));
    }
}
