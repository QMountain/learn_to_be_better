package algorithm.leetcode.medium.m;

import java.util.Stack;

public class MaximumGain {

    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                if (!stack.isEmpty() && stack.peek() == 'b' && y >= x) {
                    ans += y;
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if (c == 'b') {
                if (!stack.isEmpty() && stack.peek() == 'a' && x >= y) {
                    ans += x;
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        Stack<Character> reverse = new Stack<>();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            if (pop == 'a') {
                if (!reverse.isEmpty() && reverse.peek() == 'b') {
                    ans += x;
                    reverse.pop();
                } else {
                    reverse.push(pop);
                }
            } else if (pop == 'b') {
                if (!reverse.isEmpty() && reverse.peek() == 'a') {
                    ans += y;
                    reverse.pop();
                } else {
                    reverse.push(pop);
                }
            } else {
                reverse.push(pop);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumGain maximumGain = new MaximumGain();
        System.out.println(198644 == maximumGain.maximumGain(
                "aabbrtababbabmaaaeaabeawmvaataabnaabbaaaybbbaabbabbbjpjaabbtabbxaaavsmmnblbbabaeuasvababjbbabbabbasxbbtgbrbbajeabbbfbarbagha",
                8484, 4096));
        System.out.println(19 == maximumGain.maximumGain(
                "cdbcbbaaabab", 4, 5));
        System.out.println(20 == maximumGain.maximumGain(
                "aabbaaxybbaabb", 5, 4));
    }
}
