package algorithm.leetcode.medium.c;

public class CanJump {

    public boolean canJump2(int[] nums) {
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

    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] canArrive = new boolean[length];
        canArrive[0] = true;
        for (int i = 0; i < length; i++) {
            if (canArrive[i]) {
                for (int j = 1; j <= nums[i] && i+j < length; j++) {
                    canArrive[i+j] = true;
                    if (canArrive[length-1]) {
                        return true;
                    }
                }
            }
        }
        return canArrive[length-1];
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{1}));
        System.out.println(canJump.canJump(new int[]{1, 1, 2, 2, 0,1,1}));
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
