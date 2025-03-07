package algorithm.leetcode.medium.b;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个由正整数组成的数组 nums 和一个 正 整数 k 。
 * 如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。
 * 返回数组 nums 中 非空 且 美丽 的子集数目。
 * nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。
 * 只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的子集。
 */
public class BeautifulSubsets {

    // 1 <= nums.length <= 18
    // 1 <= nums[i], k <= 1000
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (true) {
            // try find next
            int nextIndex = findNext(nums[stack.peek()], stack.peek()+1, nums, k, stack);
            if (nextIndex == -1) {
                // if not find, try replace last
                while (!stack.isEmpty()) {
                    boolean b = tryReplaceLast(stack, nums, k);
                    if (b) {
                        ans++;
                        break;
                    } else {
                        if (stack.isEmpty()) {
                            return ans;
                        }
                    }
                }
            } else {
                stack.push(nextIndex);
                ans++;
            }
        }
    }

    private int findNext(int lastNum, int fromIndex, int[] nums, int k, Stack<Integer> stack) {
        for (int i = fromIndex; i < nums.length; i++) {
            if (nums[i] != lastNum + k) {
                boolean b = true;
                for (Integer integer : stack) {
                    if (nums[integer] == nums[i] - k) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean tryReplaceLast(Stack<Integer> stack, int[] nums, int k) {
        Integer lastIndex = stack.pop();
        if (stack.isEmpty()) {
            if (lastIndex == nums.length-1) {
                return false;
            }
            stack.push(lastIndex+1);
            return true;
        }
        int lastNum = nums[stack.peek()];
        int next = findNext(lastNum, lastIndex + 1, nums, k, stack);
        if (next == -1) {
            return false;
        }
        stack.push(next);
        return true;
    }

    public static void main(String[] args) {
        BeautifulSubsets beautifulSubsets = new BeautifulSubsets();
        System.out.println(23 == beautifulSubsets.beautifulSubsets(new int[]{10,4,5,7,2,1}, 3));
        System.out.println(23 == beautifulSubsets.beautifulSubsets(new int[]{4,2,5,9,10,3}, 1));
        System.out.println(4 == beautifulSubsets.beautifulSubsets(new int[]{2, 4, 6}, 2));
    }

}
