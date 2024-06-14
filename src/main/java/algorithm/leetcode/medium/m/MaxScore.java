package algorithm.leetcode.medium.m;

public class MaxScore {

    // 2 <= nums.length <= 10^5
    // 1 <= nums[i], x <= 10^6
    public long maxScore(int[] nums, int x) {
        // odd 奇数
        long oddMax = 0;
        // even 偶数
        long evenMax = 0;
        boolean findOdd = nums[0] % 2 == 1;
        boolean findEven = !findOdd;
        for (int num : nums) {
            if (num % 2 == 0) {
                if (!findEven) {
                    findEven = true;
                    evenMax = oddMax + num - x;
                } else {
                    evenMax += num;
                    if (findOdd) {
                        long m = oddMax + num - x;
                        evenMax = Math.max(evenMax, m);
                    }
                }
            } else {
                if (!findOdd) {
                    findOdd = true;
                    oddMax = evenMax + num - x;
                } else {
                    oddMax += num;
                    if (findEven) {
                        long m = evenMax + num - x;
                        oddMax = Math.max(oddMax, m);
                    }
                }
            }
        }
        return Math.max(oddMax, evenMax);
    }

    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        System.out.println(20 == maxScore.maxScore(new int[]{2,4,6,8}, 3));
        System.out.println(13 == maxScore.maxScore(new int[]{2,3,6,1,9,2}, 5));
    }
}
