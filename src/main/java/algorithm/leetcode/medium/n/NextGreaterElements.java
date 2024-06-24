package algorithm.leetcode.medium.n;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements {

    // 1 <= nums.length <= 10^4
    // -10^9 <= nums[i] <= 10^9
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = -1;
            int find = -1;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] > nums[i]) {
                    find = j;
                    break;
                }
            }
            if (find != -1) {
                ans[i] = nums[find];
            } else {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElements nextGreaterElements = new NextGreaterElements();
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(
                new int[]{1,5,3,6,8})));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(
                new int[]{1,2,3,4,3})));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(
                new int[]{1,2,1})));
    }
}
