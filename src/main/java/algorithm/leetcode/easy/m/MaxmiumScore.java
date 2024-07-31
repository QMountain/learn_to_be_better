package algorithm.leetcode.easy.m;

import java.util.Arrays;

public class MaxmiumScore {

    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int sum = 0;
        Integer lastOdd = null;
        Integer lastEven = null;
        for (int i = cards.length-1; i >= cards.length-cnt; i--) {
            sum += cards[i];
            if (cards[i] % 2 == 1) {
                lastOdd = cards[i];
            } else {
                lastEven = cards[i];
            }
        }
        if (sum % 2 == 0) {
            return sum;
        }
        Integer oddToEven = null;
        Integer evenToOdd = null;
        for (int i = cards.length-cnt-1; i >= 0; i--) {
            if (cards[i] % 2 == 1) {
                if (lastEven != null && evenToOdd == null) {
                    evenToOdd = lastEven - cards[i];
                }
            } else {
                if (lastOdd != null && oddToEven == null) {
                    oddToEven = lastOdd - cards[i];
                }
            }
            if (oddToEven != null && evenToOdd != null) {
                break;
            }
            if (lastOdd == null && evenToOdd != null) {
                return sum - evenToOdd;
            }
            if (lastEven == null && oddToEven != null) {
                return sum - oddToEven;
            }
        }
        if (oddToEven == null && evenToOdd == null) {
            return 0;
        }
        if (oddToEven == null) {
            return sum - evenToOdd;
        }
        if (evenToOdd == null) {
            return sum - oddToEven;
        }
        return sum - Math.min(oddToEven, evenToOdd);
    }

    public static void main(String[] args) {
        MaxmiumScore maxmiumScore = new MaxmiumScore();
        System.out.println(0 == maxmiumScore.maxmiumScore(
                new int[]{3,3,1}, 1));
        System.out.println(18 == maxmiumScore.maxmiumScore(
                new int[]{1,2,8,9}, 3));
    }
}
