package algorithm.leetcode.easy.r;

public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {
        int length = s.length();
        int leftIndex= 0;
        int countLeft = 0;
        int countRight = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                countLeft++;
            } else {
                countRight++;
            }
            if (countLeft == countRight) {
                String substring = s.substring(leftIndex+1, i);
                sb.append(substring);
                leftIndex = i+1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        System.out.println(removeOuterParentheses.removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses.removeOuterParentheses("(()())(())"));
    }
}
