package algorithm.leetcode.medium.m;

public class MinimumPossibleSum {

    public int minimumPossibleSum(int n, int target) {
        int smallerMax = target / 2;
        if (n <= smallerMax) {
            return (1 + n) * n / 2 % 1000_000_007;
        }
        long smallerSum = cal(1, smallerMax);
        long largerSum = cal(target, n - smallerMax);
        return (int) ((smallerSum + largerSum) % 1000_000_007);
    }

    private long cal(int start, int xs) {
        long end = start + xs - 1;
        if (xs % 2 == 0) {
            return (start + end) * (xs >> 1) % 1000_000_007;
        }
        return ((start + end) >> 1) * xs % 1000_000_007;
    }

    public static void main(String[] args) {
        MinimumPossibleSum minimumPossibleSum = new MinimumPossibleSum();
        System.out.println(1 == minimumPossibleSum.minimumPossibleSum(1, 1));
        System.out.println(8 == minimumPossibleSum.minimumPossibleSum(3, 3));
        System.out.println(4 == minimumPossibleSum.minimumPossibleSum(2, 3));
    }
}
