package algorithm.leetcode.medium.c;

public class CanJump {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int canJumpMaxIndex = nums[0];
        int jumpFrom = 0;
        while (true) {
            int maxStep = nums[jumpFrom];
            canJumpMaxIndex = Math.max(canJumpMaxIndex,jumpFrom+maxStep);
            if (canJumpMaxIndex >= length-1) {
                return true;
            }
            if (canJumpMaxIndex > jumpFrom) {
                jumpFrom++;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{1}));
        System.out.println(canJump.canJump(new int[]{1, 1, 2, 2, 0,1,1}));
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
