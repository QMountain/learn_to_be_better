package algorithm.leetcode.medium.d;

import java.util.*;

public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String expression) {
        List<String> multiList = new ArrayList<>();
        String[] splitWithMulti = expression.split("\\*");
        multiList.add(splitWithMulti[0]);
        for (int i = 1; i < splitWithMulti.length; i++) {
            multiList.add("*");
            multiList.add(splitWithMulti[i]);
        }
        List<String> plusList = new ArrayList<>();
        for (String s : multiList) {
            if (s.contains("+")) {
                String[] split = s.split("\\+");
                plusList.add(split[0]);
                for (int i = 1; i < split.length; i++) {
                    plusList.add("+");
                    plusList.add(split[i]);
                }
            } else {
                plusList.add(s);
            }
        }
        List<String> minusList = new ArrayList<>();
        for (String s : plusList) {
            if (s.contains("-")) {
                String[] split = s.split("-");
                minusList.add(split[0]);
                for (int i = 1; i < split.length; i++) {
                    minusList.add("-");
                    minusList.add(split[i]);
                }
            } else {
                minusList.add(s);
            }
        }
        Map<String,List<Integer>> map = new HashMap<>();
        return calByList(minusList,0, minusList.size()-1, map);
    }

    public int cal(int num1, int num2, String cal) {
        if (Objects.equals(cal, "*")) {
            return num1 * num2;
        } else if (Objects.equals(cal, "+")) {
            return num1 + num2;
        }
        return num1 - num2;
    }

    public List<Integer> calByList(List<String> list,int left, int right,Map<String,List<Integer>> map) {
        List<Integer> ansList = new ArrayList<>();
        if (left == right) {
            ansList.add(Integer.parseInt(list.get(left)));
            return ansList;
        }
        if (left + 2 == right) {
            int n1 = Integer.parseInt(list.get(left));
            int n2 = Integer.parseInt(list.get(right));
            ansList.add(cal(n1,n2,list.get(left+1)));
            return ansList;
        }
        for (int i = left+1; i < right; i+=2) {
            List<Integer> leftList;
            String leftKey = left + ","+(i-1);
            if (map.containsKey(leftKey)) {
                leftList = map.get(leftKey);
            } else {
                leftList = calByList(list, left, i-1,map);
            }
            List<Integer> rightList;
            String rightKey = (i+1)+","+right;
            if (map.containsKey(rightKey)) {
                rightList = map.get(rightKey);
            } else {
                rightList = calByList(list, i+1, right,map);
            }
            for (Integer li : leftList) {
                for (Integer ri : rightList) {
                    ansList.add(cal(li,ri,list.get(i)));
                }
            }
        }
        map.put(left+","+right,ansList);
        return ansList;
    }

    public static void main(String[] args) {
        DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        System.out.println(diffWaysToCompute.diffWaysToCompute("2*3-4*5"));
        System.out.println(diffWaysToCompute.diffWaysToCompute("2-1-1"));
    }
}
