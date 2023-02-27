package algorithm.leetcode.easy.f;

import java.util.Arrays;

public class FillCups {

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[1] == 0) {
            return amount[2];
        }
        int leftTwo = amount[0] + amount[1];
        if (amount[2] >= leftTwo) {
            amount[0] = 0;
            amount[1] = 0;
            amount[2] -= leftTwo;
            return leftTwo + fillCups(amount);
        }
        amount[1] -= 1;
        amount[2] -= 1;
        return 1 + fillCups(amount);
    }

    public static void main(String[] args) {
        FillCups fillCups = new FillCups();
        System.out.println(5 == fillCups.fillCups(new int[]{5, 0, 0}));
        System.out.println(7 == fillCups.fillCups(new int[]{5, 4, 4}));
        System.out.println(4 == fillCups.fillCups(new int[]{1, 4, 2}));
    }
}
