package algorithm.leetcode.medium.f;

import java.util.Arrays;
import java.util.Stack;

public class FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->{
            if (a[0] == b[0] && a[1] == b[1]) {
                return 0;
            }
            if (a[1] <= b[0]) {
                return -1;
            }
            if (b[1] <= a[0]) {
                return 1;
            }
            if (a[0] >= b[0] && a[1] <= b[1]) {
                return -1;
            }
            if (a[0] <= b[0] && a[1] >= b[1]) {
                return 1;
            }
            if (a[0]+a[1] != b[0]+b[1]) {
                return a[0]+a[1]-b[0]-b[1];
            }
            return a[0]-b[0];
        });
        Stack<Integer> stack = new Stack<>();
        int length = pairs.length;
        stack.push(0);
        for (int i = 1; i < length; i++) {
            int[] lastPair = pairs[stack.peek()];
            int[] currPair = pairs[i];
            if (lastPair[1] < currPair[0]) {
                stack.push(i);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        FindLongestChain findLongestChain = new FindLongestChain();
        System.out.println(findLongestChain.findLongestChain(new int[][]{{1,2}, {2,3}, {3,4}}));
    }
}
