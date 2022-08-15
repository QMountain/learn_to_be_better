package algorithm.leetcode.medium.e;

import java.util.Stack;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num1 + num2));
                    break;
                }
                case "-": {
                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num1 - num2));
                    break;
                }
                case "*": {
                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num1 * num2));
                    break;
                }
                case "/": {
                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num1 / num2));
                    break;
                }
                default:
                    stack.push(token);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(22 == evalRPN.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println(6 == evalRPN.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(9 == evalRPN.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
