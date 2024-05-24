package algorithm.leetcode.medium.n;

public class NumberOfWeeks {

    // n == milestones.length
    // 1 <= n <= 10^5
    // 1 <= milestones[i] <= 10^9
    public long numberOfWeeks(int[] milestones) {
        if (milestones.length == 1) {
            return 1L;
        }
        int max = milestones[0];
        long totalSum = 0;
        for (int milestone : milestones) {
            totalSum += milestone;
            max = Math.max(max, milestone);
        }
        if ((totalSum + 1) >> 1 < max) {
            return ((totalSum - max) << 1) + 1;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        NumberOfWeeks numberOfWeeks = new NumberOfWeeks();
        System.out.println(24 == numberOfWeeks.numberOfWeeks(new int[]{8,8,2,6}));
        System.out.println(40 == numberOfWeeks.numberOfWeeks(new int[]{5,7,5,7,9,7}));
        System.out.println(41 == numberOfWeeks.numberOfWeeks(new int[]{9,7,4,6,1,5,3,6}));

        System.out.println(29 == numberOfWeeks.numberOfWeeks(new int[]{9,3,6,8,2,1}));
        System.out.println(7 == numberOfWeeks.numberOfWeeks(new int[]{5,2,1}));
        System.out.println(6 == numberOfWeeks.numberOfWeeks(new int[]{1,2,3}));
    }
}
