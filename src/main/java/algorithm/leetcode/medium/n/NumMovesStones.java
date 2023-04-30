package algorithm.leetcode.medium.n;

import java.util.Arrays;

public class NumMovesStones {

    public int[] numMovesStones(int a, int b, int c) {
        int min = Math.min(Math.min(a,b), c);
        int max = Math.max(Math.max(a,b), c);
        int mid = a + b + c - min - max;
        if (min + 1 == mid) {
            // 三个连续
            if (mid + 1 == max) {
                return new int[]{0, 0};
            }
            // 两个连续
            return new int[]{1, max - mid - 1};
        }
        if (mid + 1 == max) {
            return new int[]{1, mid - min - 1};
        }
        if (min + 2 == mid) {
            return new int[]{1, max - mid};
        }
        if (mid + 2 == max) {
            return new int[]{1, mid - min};
        }
        return new int[]{2, max - min - 2};
    }

    public static void main(String[] args) {
        NumMovesStones numMovesStones = new NumMovesStones();
        System.out.println(Arrays.toString(numMovesStones.numMovesStones(3, 5, 1)));
        System.out.println(Arrays.toString(numMovesStones.numMovesStones(4, 3, 2)));
        System.out.println(Arrays.toString(numMovesStones.numMovesStones(1, 2, 5)));
    }
}
