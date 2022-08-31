package algorithm.leetcode.medium.v;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < popped.length) {
            while (stack.isEmpty() || stack.peek() != popped[popIndex]) {
                if (pushIndex < pushed.length) {
                    stack.push(pushed[pushIndex++]);
                } else {
                    return false;
                }
            }
            stack.pop();
            popIndex++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        System.out.println(validateStackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(validateStackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
