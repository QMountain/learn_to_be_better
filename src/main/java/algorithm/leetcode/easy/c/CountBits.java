package algorithm.leetcode.easy.c;

import java.util.Arrays;

public class CountBits {

    public int[] countBits(int n) {
        int[] resArr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            resArr[i] = count(i);
        }
        return resArr;
    }

    public int count(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.println(Arrays.toString(countBits.countBits(8)));
    }
}
