package algorithm.swordtowardoffer.easy;

import java.util.Arrays;

/**
 * @ClassName AdjustArrayOrder
 * @Description 调整数组顺序使奇数位于偶数前面
 * @Author qsf
 * Date   2021-12-03  23:27
 */
public class AdjustArrayOrder {

    public int[] exchange(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int leftPointer = 0;
        int rightPointer = nums.length-1;
        int temp;
        while (leftPointer+1 <= rightPointer) {
            if (nums[leftPointer] % 2 == 1) {
                leftPointer++;
                continue;
            }
            if (nums[rightPointer] % 2 == 0) {
                rightPointer--;
                continue;
            }
            temp = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        return nums;
    }

    public static void main(String[] args) {
        AdjustArrayOrder adjustArrayOrder = new AdjustArrayOrder();
        int[] nums = new int[]{1,2,3,4};
        int[] exchange = adjustArrayOrder.exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }
}
