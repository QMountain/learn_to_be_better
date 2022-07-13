package algorithm.leetcode.hard.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluate {

    public int evaluate(String expression) {
        Map<String ,Integer> map = new HashMap<>();
        return cal(expression,map);
    }

    public int cal(String expression, Map<String ,Integer> map) {
        int firstCal = expression.indexOf(" ");
        String firstCalString = expression.substring(0, firstCal);
        expression = expression.substring(firstCal+1,expression.length()-1);
        // let expression
        if (firstCalString.equals("(let")) {
            if (expression.contains("(")) {
                List<String> list = new ArrayList<>();
                while (expression.length() > 0) {
                    int i = expression.indexOf(" ");
                    if (i == -1) {
                        list.add(expression);
                        break;
                    }
                    String substring = expression.substring(0, i);
                    if (!substring.contains("(")) {
                        list.add(substring);
                        expression = expression.substring(i+1);
                        continue;
                    }
                    int countLeft = 0;
                    int countRight = 0;
                    for (int j = 0; j < expression.length(); j++) {
                        if (expression.charAt(j) == '(') {
                            countLeft++;
                        }
                        if (expression.charAt(j) == ')') {
                            countRight++;
                        }
                        if (countLeft == countRight) {
                            list.add(expression.substring(0,j+1));
                            if (j == expression.length()-1) {
                                expression = "";
                                break;
                            }
                            expression = expression.substring(j+2);
                            break;
                        }
                    }
                }
                int size = list.size();
                String lastExpression = list.get(size-1);
                if (isNumber(lastExpression)) {
                    return Integer.parseInt(lastExpression);
                }
                for (int i = 1; i < size-1; i+=2) {
                    String s = list.get(i);
                    if (isNumber(s)) {
                        map.put(list.get(i-1),Integer.parseInt(s));
                    } else {
                        if (map.containsKey(s)) {
                            map.put(list.get(i-1),map.get(s));
                        } else {
                            int cal = cal(s, new HashMap<>(map));
                            map.put(list.get(i-1),cal);
                        }
                    }
                }
                if (needCal(lastExpression)) {
                    return cal(lastExpression,new HashMap<>(map));
                }
                return map.get(lastExpression);
            }

            String[] split = expression.split(" ");
            for (int j = 1; j < split.length-1; j+=2) {
                if (isNumber(split[j])) {
                    map.put(split[j-1],Integer.parseInt(split[j]));
                } else {
                    if (map.containsKey(split[j])) {
                        map.put(split[j-1],map.get(split[j]));
                    } else {
                        int cal = cal(split[j], new HashMap<>(map));
                        map.put(split[j-1],cal);
                    }
                }
            }
            String lastExpression = split[split.length - 1];
            if (isNumber(lastExpression)) {
                return Integer.parseInt(lastExpression);
            }
            return map.get(lastExpression);
        }

        String s1;
        String s2;
        if (expression.startsWith("(")) {
            int countLeft = 0;
            int countRight = 0;
            int firstPartEnd = 0;
            for (int j = 0; j < expression.length(); j++) {
                if (expression.charAt(j) == '(') {
                    countLeft++;
                }
                if (expression.charAt(j) == ')') {
                    countRight++;
                }
                if (countLeft == countRight) {
                    firstPartEnd = j;
                    break;
                }
            }
            s1 = expression.substring(0,firstPartEnd+1);
            s2 = expression.substring(firstPartEnd+2);
        } else {
            int i = expression.indexOf(" ");
            s1 = expression.substring(0,i);
            s2 = expression.substring(i+1);
        }
        int v1;
        int v2;
        if (isNumber(s1)) {
            v1 = Integer.parseInt(s1);
        } else if (needCal(s1)) {
            v1 = cal(s1, new HashMap<>(map));
        } else {
            v1 = map.get(s1);
        }
        if (isNumber(s2)) {
            v2 = Integer.parseInt(s2);
        } else if (needCal(s2)) {
            v2 = cal(s2, new HashMap<>(map));
        } else {
            v2 = map.get(s2);
        }
        if (firstCalString.equals("(add")) {
            return v1+v2;
        }
        return v1*v2;
    }

    public boolean needCal(String str) {
        return str.contains("let") || str.contains("add") || str.contains("mult");
    }

    public boolean isNumber(String str) {
        int start = 0;
        if (str.startsWith("-")) {
            start = 1;
        }
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Evaluate evaluate = new Evaluate();
        System.out.println(evaluate.evaluate("(let foo 2 foo foo foo (let bar (let bar 4 foo 7 (add bar bar)) (mult foo bar)) foo foo foo)"));
        System.out.println(evaluate.evaluate("(let x -2 y x y)"));
        System.out.println(evaluate.evaluate("(let x 7 -12)"));
        System.out.println(evaluate.evaluate("(let a1 3 b2 (add a1 1) b2)"));
        System.out.println(evaluate.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
        System.out.println(evaluate.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        System.out.println(evaluate.evaluate("(let x 3 x 2 x)"));
        System.out.println(evaluate.evaluate(
                "(let x 2 (mult x (let x 3 y 4 (add x y))))"));
    }
}
