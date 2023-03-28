package algorithm.leetcode.easy.k;

public class KItemsWithMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }
        k -= numOnes;
        if (numZeros >= k) {
            return numOnes;
        }
        k -= numZeros;
        return numOnes - k;
    }

    public static void main(String[] args) {
        KItemsWithMaximumSum kItemsWithMaximumSum = new KItemsWithMaximumSum();
        System.out.println(3 == kItemsWithMaximumSum.kItemsWithMaximumSum(3, 2, 0, 4));
        System.out.println(2 == kItemsWithMaximumSum.kItemsWithMaximumSum(3, 2, 0, 2));
    }
}
