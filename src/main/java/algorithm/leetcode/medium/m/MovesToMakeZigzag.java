package algorithm.leetcode.medium.m;

public class MovesToMakeZigzag {

    // 1 <= nums.length <= 1000
    // 1 <= nums[i] <= 1000
    public int movesToMakeZigzag(int[] nums) {
        // 第一个大，cut奇数位的
        int firstBigNeedCut = 0;
        // 第一个小，cut偶数位的
        int firstSmallNeedCut = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                int min = Integer.MAX_VALUE;
                if (i > 0) {
                    min = Math.min(min, nums[i-1]);
                }
                if (i < nums.length-1) {
                    min = Math.min(min, nums[i+1]);
                }
                if (nums[i] >= min) {
                    firstSmallNeedCut += nums[i] - min + 1;
                }
            } else {
                int min = nums[i - 1];
                if (i < nums.length-1) {
                    min = Math.min(min, nums[i+1]);
                }
                if (nums[i] >= min) {
                    firstBigNeedCut += nums[i] - min + 1;
                }
            }
        }
        return Math.min(firstBigNeedCut,firstSmallNeedCut);
    }

    public static void main(String[] args) {
        MovesToMakeZigzag movesToMakeZigzag = new MovesToMakeZigzag();
        System.out.println(2 == movesToMakeZigzag.movesToMakeZigzag(new int[]{1,2,3}));
        System.out.println(4 == movesToMakeZigzag.movesToMakeZigzag(new int[]{9,6,1,6,2}));
    }
}
