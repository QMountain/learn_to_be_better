package algorithm.leetcode.medium.s;

public class ScoreOfParentheses {

    // 用栈好些
    public int scoreOfParentheses(String s) {
        int length = s.length();
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                countLeft++;
            } else {
                countRight++;
            }
            if (countLeft == countRight) {
                int n1 = 0;
                String s1 = s.substring(1, i);
                if (s1.equals("")) {
                    n1 = 1;
                } else {
                    n1 = scoreOfParentheses(s1) * 2;
                }
                int n2 = 0;
                String s2 = s.substring(i + 1);
                if (s2.length() == 2) {
                    n2 = 1;
                } else if (s2.length() > 2) {
                    n2 = scoreOfParentheses(s2);
                }
                return n1 + n2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
        System.out.println(6 == scoreOfParentheses.scoreOfParentheses("(()(()))"));
        System.out.println(2 == scoreOfParentheses.scoreOfParentheses("()()"));
        System.out.println(2 == scoreOfParentheses.scoreOfParentheses("(())"));
        System.out.println(1 == scoreOfParentheses.scoreOfParentheses("()"));
    }
}
