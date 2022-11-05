package algorithm.leetcode.hard.p;

public class ParseBoolExpr {

    public boolean parseBoolExpr(String expression) {
        int length = expression.length();
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                lastIndex = i;
                continue;
            }
            if (c == ')') {
                String left = expression.substring(0, lastIndex - 1);
                String calOne = calOne(expression.substring(lastIndex - 1, i + 1));
                String right = expression.substring(i+1);
                return parseBoolExpr(left+calOne+right);
            }
        }
        return expression.equals("t");
    }

    public String calOne(String str) {
        char c = str.charAt(0);
        if (c == '!') {
            if (str.charAt(2) == 't') {
                return "f";
            }
            return "t";
        }
        str = str.substring(2,str.length()-1);
        String[] split = str.split(",");
        if (c == '&') {
            for (String s : split) {
                if (s.equals("f")) {
                    return "f";
                }
            }
            return "t";
        }
        for (String s : split) {
            if (s.equals("t")) {
                return "t";
            }
        }
        return "f";
    }

    public static void main(String[] args) {
        ParseBoolExpr parseBoolExpr = new ParseBoolExpr();
        System.out.println(parseBoolExpr.parseBoolExpr("|(&(t,f,t),!(t))"));
        System.out.println(parseBoolExpr.parseBoolExpr("&(t,f)"));
        System.out.println(parseBoolExpr.parseBoolExpr("|(f,t)"));
        System.out.println(parseBoolExpr.parseBoolExpr("!(f)"));
    }
}
