package algorithm.leetcode.easy.m;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * 面试题 17.10. 主要元素
     * 数组中占比超过一半的元素称之为主要元素。
     * 给你一个 整数 数组，找出其中的主要元素。
     * 若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
     */
    public int majorityElement(int[] nums) {
        boolean find = false;
        int countZero = 0;
        int[] arr = new int[32];
        for (int num : nums) {
            if (num < 0) {
                find = true;
                continue;
            } else if (num == 0) {
                countZero++;
            }
            String binaryString = Integer.toBinaryString(num);
            int biLen = binaryString.length();
            for (int i = 0; i < biLen; i++) {
                char c = binaryString.charAt(i);
                arr[32-biLen+i] += c - '0';
            }
        }
        if (countZero > nums.length / 2) {
            return 0;
        }
        int base = 0;
        for (int i = 0; i < 32; i++) {
            if (arr[i] > nums.length / 2) {
                base |= 1 << (31 - i);
            }
        }
        if (base == 0) {
            return nums[0];
        }
        for (int num : nums) {
            if (num >= 0) {
                if ((num | base) == num) {
                    int count = 0;
                    for (int i : nums) {
                        if (i == num) {
                            if (++count > nums.length / 2) {
                                return num;
                            }
                        }
                    }
                }
            }
        }
        if (find) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = -nums[i];
            }
            return majorityElement(nums);
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer oldCount = map.getOrDefault(num, 0);
            if (oldCount == length/2) {
                return num;
            } else {
                map.put(num,oldCount+1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(0 == majorityElement.majorityElement(
                new int[]{-2147483648,0,0}));
        System.out.println(-2147483648 == majorityElement.majorityElement(
                new int[]{-2147483648}));
        System.out.println(1 == majorityElement.majorityElement(
                new int[]{-1,1,1,1,2,1}));
        System.out.println(5 == majorityElement.majorityElement(
                new int[]{1,2,5,9,5,9,5,5,5}));

        System.out.println(3 == majorityElement.majorityElement(new int[]{3,2,3}));
        System.out.println(2 == majorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }


}
