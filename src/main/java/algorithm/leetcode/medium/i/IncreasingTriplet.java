package algorithm.leetcode.medium.i;

public class IncreasingTriplet {

    // 题号334 递增的三元子序列 此方法是O(n) 但是遍历的3次，而且空间仍是O(n)
    // 官解使用了贪心算法，同时维护first second，然后查找third的同时更新first，second，可以做到遍历1次，空间O(1)
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int[] smallest = new int[length];
        smallest[0] = nums[0];
        for (int i = 1; i < length; i++) {
            smallest[i] = Math.min(smallest[i-1],nums[i-1]);
        }
        int[] biggest = new int[length];
        biggest[length-1] = nums[length-1];
        for (int i = length-2; i >= 0; i--) {
            biggest[i] = Math.max(biggest[i+1],nums[i+1]);
        }
        for (int i = 1; i < length-1; i++) {
            if (smallest[i] < nums[i] && nums[i] < biggest[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(new int[]{2,1,5,0,4,6}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{1,2,3,4,5}));
    }
}
