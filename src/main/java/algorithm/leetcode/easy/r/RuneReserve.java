package algorithm.leetcode.easy.r;

import java.util.Arrays;

public class RuneReserve {

    // 1 <= runes.length <= 10^4
    // 0 <= runes[i] <= 10^4
    public int runeReserve(int[] runes) {
        Arrays.sort(runes);
        int ans = 1;
        int count = 1;
        for (int i = 1; i < runes.length; i++) {
            if (runes[i] - runes[i-1] <= 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        return Math.max(ans, count);
    }

    public static void main(String[] args) {
        RuneReserve runeReserve = new RuneReserve();
        System.out.println(3 == runeReserve.runeReserve(new int[]{1,3,5,4,1,7}));
    }
}
