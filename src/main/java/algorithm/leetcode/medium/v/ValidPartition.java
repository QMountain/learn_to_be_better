package algorithm.leetcode.medium.v;

public class ValidPartition {

    // 2 <= nums.length <= 10^5
    public boolean validPartition(int[] nums) {
        if (nums[0] != nums[1] && nums[0] + 1 != nums[1]) {
            return false;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        int i3 = 7;
        int i2 = 0;
        int i1 = nums[0] == nums[1] ? 1 : 0;
        int curr = 7;
        // 三位二进制
        // 001 = 1 代表这个数可以组成连续2个相等
        // 010 = 2 代表这个数可以组成连续3个相等
        // 100 = 4 代表这个数可以组成连续3个递增
        // 到每一个index,如果
        for (int i = 2; i < nums.length; i++) {
            curr = 0;
            if (nums[i] == nums[i-1] && i2 > 0) {
                curr |= 1;
            }
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] && i3 > 0) {
                curr |= 2;
            }
            if (nums[i] == nums[i-1] + 1 && nums[i] == nums[i-2] + 2 && i3 > 0) {
                curr |= 4;
            }
            i3 = i2;
            i2 = i1;
            i1 = curr;
        }
        return curr > 0;
    }

    public static void main(String[] args) {
        ValidPartition validPartition = new ValidPartition();
        System.out.println(validPartition.validPartition(new int[]{1,2}));
        System.out.println(validPartition.validPartition(new int[]{1,1,1,2}));
        System.out.println(validPartition.validPartition(new int[]{4,4,4,5,6}));
    }
}
