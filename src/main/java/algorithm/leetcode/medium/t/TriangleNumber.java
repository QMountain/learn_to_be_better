package algorithm.leetcode.medium.t;

import java.util.Arrays;

public class TriangleNumber {

    /**
     * 611. 有效三角形的个数
     * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                if (j < nums.length - 1 && a + b > nums[j+1]) {
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (a + b > nums[mid]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    ans += right - j;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TriangleNumber triangleNumber = new TriangleNumber();
        System.out.println(3 == triangleNumber.triangleNumber(new int[]{2,2,3,4}));
        System.out.println(4 == triangleNumber.triangleNumber(new int[]{4,2,3,4}));
    }

}
