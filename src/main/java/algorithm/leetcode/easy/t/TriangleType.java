package algorithm.leetcode.easy.t;

import java.util.Arrays;

public class TriangleType {

    /**
     * 给你一个下标从 0 开始长度为 3 的整数数组 nums ，需要用它们来构造三角形。
     * 如果一个三角形的所有边长度相等，那么这个三角形称为 equilateral 。
     * 如果一个三角形恰好有两条边长度相等，那么这个三角形称为 isosceles 。
     * 如果一个三角形三条边的长度互不相同，那么这个三角形称为 scalene 。
     * 如果这个数组无法构成一个三角形，请你返回字符串 "none" ，否则返回一个字符串表示这个三角形的类型。
     * nums.length == 3
     * 1 <= nums[i] <= 100
     */
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        }
        return "scalene";
    }

    public static void main(String[] args) {
        TriangleType triangleType = new TriangleType();
        System.out.println("equilateral".equals(triangleType.triangleType(
                new int[]{3, 3, 3})));
    }
}
