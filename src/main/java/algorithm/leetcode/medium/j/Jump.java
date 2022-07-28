package algorithm.leetcode.medium.j;

public class Jump {

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(2 == jump.jump(new int[]{1,2,3}));
        System.out.println(1 == jump.jump(new int[]{2,1}));
        System.out.println(2 == jump.jump(new int[]{2,3,0,1,4}));
        System.out.println(2 == jump.jump(new int[]{2,3,1,1,4}));
    }
}
