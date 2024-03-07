package algorithm.leetcode.medium.d;

import java.util.Arrays;

public class DivisibilityArray {

    public int[] divisibilityArray(String word, int m) {
        int length = word.length();
        int[] ans = new int[length];
        long num = 0;
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int n = c - '0';
            num = num * 10 + n;
            if (num % m == 0) {
                ans[i] = 1;
                num = 0;
            }
            num %= m;
        }
        return ans;
    }

    public static void main(String[] args) {
        DivisibilityArray divisibilityArray = new DivisibilityArray();
        System.out.println(Arrays.toString(
                divisibilityArray.divisibilityArray("100000000010000000003019999999961000000000919999999907999999993829999999901000000000999999999110000000001000000000100000000010000000007199999999210000000001000000000309999999975999999995100000000010000000001000000000100000000082299999998826999999992100000000010000000001000000000599999999590099999999110000000006999999994744597999999964199", 1000000000)));
        System.out.println(Arrays.toString(
                divisibilityArray.divisibilityArray("4868438856666666", 6)));
        System.out.println(Arrays.toString(
                divisibilityArray.divisibilityArray("998244353", 3)));
    }
}
