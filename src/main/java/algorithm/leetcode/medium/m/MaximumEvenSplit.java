package algorithm.leetcode.medium.m;

import java.util.ArrayList;
import java.util.List;

public class MaximumEvenSplit {

    public List<Long> maximumEvenSplit(long finalSum) {
        long sqrt = (long) Math.sqrt(finalSum * 4 + 1);
        List<Long> ansList = new ArrayList<>();
        for (long i = 2; i < sqrt-2; i+=2) {
            ansList.add(i);
            finalSum -= i;
        }
        if (finalSum == 0) {
            return ansList;
        }
        if (finalSum % 2 == 0) {
            ansList.add(finalSum);
            return ansList;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        MaximumEvenSplit maximumEvenSplit = new MaximumEvenSplit();
        System.out.println(maximumEvenSplit.maximumEvenSplit(12));
        System.out.println(maximumEvenSplit.maximumEvenSplit(7));
        System.out.println(maximumEvenSplit.maximumEvenSplit(28));
    }

}
