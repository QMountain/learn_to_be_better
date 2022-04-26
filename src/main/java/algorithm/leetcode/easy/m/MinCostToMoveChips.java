package algorithm.leetcode.easy.m;

public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        // 奇数
        int countOddNumber = 0;
        // 偶数
        int countEvenNumber = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                countEvenNumber++;
            } else {
                countOddNumber++;
            }
        }
        return Math.min(countOddNumber,countEvenNumber);
    }

}
