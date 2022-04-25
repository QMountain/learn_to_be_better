package algorithm.leetcode.easy.n;

import java.util.*;

public class NextGreaterElement {

    /*public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int n2Len = nums2.length;
        int[] resArr = new int[length];
        for (int i = 0; i < length; i++) {
            int n = nums1[i];
            for (int j = 0; j < n2Len; j++) {
                if (nums2[j] == n) {
                    int index = -1;
                    for (int k = j+1; k < n2Len; k++) {
                        if (nums2[k] > n) {
                            index = k;
                            break;
                        }
                    }
                    if (index == -1) {
                        resArr[i] = index;
                    } else {
                        resArr[i] = nums2[index];
                    }
                }
            }
        }
        return resArr;
    }*/

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

}
