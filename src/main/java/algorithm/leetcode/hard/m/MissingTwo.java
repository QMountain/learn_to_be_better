package algorithm.leetcode.hard.m;

import java.util.Arrays;

public class MissingTwo {

    // 面试题17.19.消失的两个数字
    // 以超过6%的结果通过了，但是官解是位运算
    public int[] missingTwo(int[] nums) {
        int length = nums.length;
        int first = -1;
        int second = -1;
        int a0 = -1;
        int a1 = -1;
        int a2 = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                first = 1;
            } else if (nums[i] == 2) {
                second = 2;
            } else if (nums[i] != i+3) {
                int putIndex = nums[i];
                while (nums[putIndex-3] != putIndex) {
                    int next = nums[putIndex-3];
                    nums[putIndex-3] = putIndex;
                    if (next == 1) {
                        first = 1;
                        break;
                    }
                    if (next == 2) {
                        second = 2;
                        break;
                    }
                    if (next == -1) {

                        if (a0 == putIndex) {
                            a0 = -1;
                        } else if (a1 == putIndex) {
                            a1 = -1;
                        } else if (a2 == putIndex) {
                            a2 = -1;
                        }
                        break;
                    }
                    putIndex = next;
                }
            }

            if (nums[i] != i+3) {
                if (a0 == -1) {
                    a0 = i+3;
                } else if (a1 == -1) {
                    a1 = i+3;
                } else {
                    a2 = i+3;
                }
                nums[i] = -1;
            }
        }
        int[] ans = new int[2];
        int p = 0;
        if (first == -1) {
            ans[p++] = 1;
        }
        if (second == -1) {
            ans[p++] = 2;
        }
        if (a0 != -1) {
            ans[p++] = a0;
        }
        if (a1 != -1) {
            ans[p++] = a1;
        }
        if (a2 != -1) {
            ans[p] = a2;
        }
        return ans;
    }

    public static void main(String[] args) {
        MissingTwo missingTwo = new MissingTwo();
        System.out.println(Arrays.toString(missingTwo.missingTwo(new int[]{2,3})));
        System.out.println(Arrays.toString(missingTwo.missingTwo(new int[]{1})));
    }
}
