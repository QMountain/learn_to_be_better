package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>(n*n);
        for (int i = n; i > 0; i--) {
            // i represent used left
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < i; j++) {
                s.append("(");
            }
            s.append(")");
            resList.addAll(appendNext(s,n-i,n-1));
        }

        return resList;
    }

    public List<String> appendNext(StringBuilder s, int leftLeft, int leftRight) {
        List<String> resList = new ArrayList<>();
        if (leftLeft == leftRight && leftRight == 1) {
            resList.add(s.append("()").toString());
            return resList;
        }
        if (leftLeft == 0) {
            for (int i = 0; i < leftRight; i++) {
                s.append(")");
            }
            resList.add(s.toString());
            return resList;
        }
        for (int i = leftLeft; i > 0; i--) {
            for (int j = 0; j < leftLeft; j++) {
                s.append("(");
            }
            s.append(")");
            resList.addAll(appendNext(s,leftLeft-i,leftRight-1));

            s = new StringBuilder(s.substring(0,s.toString().length()-i-2));
        }
        return resList;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }

}
