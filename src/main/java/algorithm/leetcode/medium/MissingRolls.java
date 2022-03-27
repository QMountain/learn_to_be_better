package algorithm.leetcode.medium;

import java.util.Arrays;

public class MissingRolls {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int mLength = rolls.length;
        int sum = (mLength+n) * mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        int[] nArr = new int[n];
        if (sum > 6*n || sum < n) {
            return new int[]{};
        }
        int average = sum/n;
        for (int i = 0; i < n; i++) {
            nArr[i] = average;
        }
        sum -= average*n;
        if (sum > 0) {
            for (int i = 0; i < sum; i++) {
                nArr[i] += 1;
            }
        }
        return nArr;
    }

    public static void main(String[] args) {
        MissingRolls missingRolls = new MissingRolls();
        System.out.println(Arrays.toString(missingRolls.missingRolls(new int[]{6,3,4,3,5,3}, 1, 6)));
        System.out.println(Arrays.toString(missingRolls.missingRolls(new int[]{1,2,3,4}, 6, 4)));
        System.out.println(Arrays.toString(missingRolls.missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
        System.out.println(Arrays.toString(missingRolls.missingRolls(new int[]{1,5,6}, 3, 4)));
    }
}
