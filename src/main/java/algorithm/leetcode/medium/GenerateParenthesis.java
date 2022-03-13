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
        if (leftLeft > leftRight) {
            return resList;
        }
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
        StringBuilder s1 = new StringBuilder(s);
        s1.append("(");
        resList.addAll(appendNext(s1,leftLeft-1,leftRight));

        StringBuilder s2 = new StringBuilder(s);
        s2.append(")");
        resList.addAll(appendNext(s2,leftLeft,leftRight-1));

        return resList;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
        System.out.println(generateParenthesis.generateParenthesis(1));
        System.out.println(generateParenthesis.generateParenthesis(4));
    }

}
