package algorithm.leetcode.medium.c;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (Math.abs(nums[i]) % length == 0) {
                nums[i] = 0;
            } else {
                nums[i] %= length;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // start index i
            int next = i;
            while (true) {
                int last = next;
                next = (next+nums[next]) % length;
                if (next < 0) {
                    next = length+next;
                }
                if (nums[next] == 0) {
                    nums[last] = 0;
                    break;
                }
                if (nums[last] * nums[next] < 0) {
                    nums[last] = 0;
                    break;
                }
                if (next == i || Math.abs(nums[next] / length) == i+1) {
                    return true;
                }
                if (nums[next] > 0) {
                    nums[next] = nums[next] % length + ((i+1)*length);
                } else {
                    nums[next] = nums[next] % length - ((i+1)*length);
                }
            }
            nums[i] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        CircularArrayLoop circularArrayLoop = new CircularArrayLoop();
        System.out.println(circularArrayLoop.circularArrayLoop(new int[]{-2,-17,-1,-2,-2}));
        System.out.println(circularArrayLoop.circularArrayLoop(new int[]{-2,1,-1,-2,-2}));
        System.out.println(circularArrayLoop.circularArrayLoop(new int[]{-1,2}));
        System.out.println(circularArrayLoop.circularArrayLoop(new int[]{2,-1,1,2,2}));

        System.out.println(!circularArrayLoop.circularArrayLoop(new int[]{-8,-1,1,7,2}));
        System.out.println(!circularArrayLoop.circularArrayLoop(new int[]{-1,-2,-3,-4,-5}));
        System.out.println(!circularArrayLoop.circularArrayLoop(new int[]{2,2,2,2,2,4,7}));
        System.out.println(circularArrayLoop.circularArrayLoop(new int[]{1,1,2}));

        System.out.println(circularArrayLoop.circularArrayLoop(new int[]{1,2,3,4,5}));


    }
}
