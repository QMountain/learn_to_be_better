package algorithm.leetcode.hard.l;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        boolean next = true;

        while (next) {
            boolean changed = false;
            for (int i = 0; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                // find first (
                if (c == '(') {
                    // sum until )
                    int between = 0;
                    for (int j = i+1; j < s.length(); j++) {
                        char cj = s.charAt(j);
                        if (cj == ')' || cj == '(') {
                            if (cj == ')') {
                                between += 2;
                                changed = true;
                                String s1 = s.substring(0, i);
                                String s2 = s.substring(j+1);
                                s = s1 +"{"+between+"}"+ s2;
                                i += 2;
                            }
                            break;
                        } else {
                            int rightIndex = j+1;
                            for (int k = j+2; k < s.length(); k++) {
                                if (s.charAt(k) == '}') {
                                    rightIndex = k;
                                    break;
                                }
                            }
                            String num = s.substring(j+1, rightIndex);
                            between += Integer.parseInt(num);
                            j = rightIndex;
                        }
                    }
                    max = Math.max(max,between);
                }

            }
            next = changed;
        }

        boolean combineNumber = true;
        while (combineNumber) {
            boolean changed = false;
            for (int i = 0; i < s.length()-1; i++) {
                if (s.charAt(i) == '{') {
                    int rightIndex = i+2;
                    for (int j = i+2; j < s.length(); j++) {
                        if (s.charAt(j) == '}') {
                            rightIndex = j;
                            break;
                        }
                    }
                    if (rightIndex < s.length()-3) {
                        if (s.charAt(rightIndex+1) == '{') {
                            int rightIndex2 = rightIndex+2;
                            for (int j = rightIndex+2; j < s.length(); j++) {
                                if (s.charAt(j) == '}') {
                                    rightIndex2 = j;
                                    break;
                                }
                            }
                            String num1 = s.substring(i+1, rightIndex);
                            String num2 = s.substring(rightIndex+2, rightIndex2);

                            changed = true;
                            String s1 = s.substring(0, i);
                            String s2 = s.substring(rightIndex2+1);
                            int m = Integer.parseInt(num1);
                            int n = Integer.parseInt(num2);
                            s = s1 +"{"+(m+n)+"}"+ s2;
                            max = Math.max(max,(m+n));
                            break;
                        }
                    }
                }
            }

            combineNumber = changed;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(2 == longestValidParentheses.longestValidParentheses("(()"));
        System.out.println(4 == longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(0 == longestValidParentheses.longestValidParentheses(""));
        System.out.println(2 == longestValidParentheses.longestValidParentheses("()(()"));
        System.out.println(6 == longestValidParentheses.longestValidParentheses("()(())"));
        System.out.println(22 == longestValidParentheses.longestValidParentheses(")(((((()())()()))()(()))("));
    }
}
