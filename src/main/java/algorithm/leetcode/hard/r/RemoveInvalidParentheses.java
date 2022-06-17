package algorithm.leetcode.hard.r;

import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        while (s.startsWith(")")) {
            s = s.substring(1);
        }
        while (s.endsWith("(")) {
            s = s.substring(0,s.length()-1);
        }
        if (s.equals("") || (!s.contains("(") && !s.contains(")"))) {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }
        int length = s.length();
        int[][] count = new int[length][2];
        if (s.charAt(0) == '(') {
            count[0][0] = 1;
        }
        Map<String,Set<String>> calMap = new HashMap<>();
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '(') {
                count[i][0] = count[i-1][0] + 1;
                count[i][1] = count[i-1][1];
            } else if (s.charAt(i) == ')') {
                count[i][0] = count[i-1][0];
                count[i][1] = count[i-1][1] + 1;
            } else {
                count[i][0] = count[i-1][0];
                count[i][1] = count[i-1][1];
            }
            if (count[i][0] < count[i][1]) {
                Set<String> ansSet = new HashSet<>();
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(j) == ')') {
                        char[] chars = s.toCharArray();
                        chars[j] = '-';
                        String ns = new String(chars).replaceFirst("-", "");
                        if (calMap.containsKey(ns)) {
                            ansSet.addAll(calMap.get(ns));
                        } else {
                            List<String> list = removeInvalidParentheses(ns);
                            ansSet.addAll(list);
                            calMap.put(ns,new HashSet<>(list));
                        }
                    }
                }
                return new ArrayList<>(ansSet);
            }
        }

        int[][] countFromRight = new int[length][2];
        if (s.charAt(length-1) == ')') {
            countFromRight[length-1][1] = 1;
        }
        for (int i = length-2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                countFromRight[i][0] = countFromRight[i+1][0] + 1;
                countFromRight[i][1] = countFromRight[i+1][1];
            } else if (s.charAt(i) == ')') {
                countFromRight[i][0] = countFromRight[i+1][0];
                countFromRight[i][1] = countFromRight[i+1][1] + 1;
            } else {
                countFromRight[i][0] = countFromRight[i+1][0];
                countFromRight[i][1] = countFromRight[i+1][1];
            }
            if (countFromRight[i][0] > countFromRight[i][1]) {
                Set<String> ansSet = new HashSet<>();
                for (int j = i; j < length; j++) {
                    if (s.charAt(j) == '(') {
                        char[] chars = s.toCharArray();
                        chars[j] = '-';
                        String ns = new String(chars).replaceFirst("-", "");
                        if (calMap.containsKey(ns)) {
                            ansSet.addAll(calMap.get(ns));
                        } else {
                            List<String> list = removeInvalidParentheses(ns);
                            ansSet.addAll(list);
                            calMap.put(ns,new HashSet<>(list));
                        }
                    }
                }
                return new ArrayList<>(ansSet);
            }
        }
        List<String> ansList = new ArrayList<>();
        ansList.add(s);
        return ansList;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("(j))("));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("))"));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("n"));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses(")("));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses.removeInvalidParentheses("()())()"));
    }
}
