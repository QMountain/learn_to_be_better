package algorithm.leetcode.easy.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalPoints {

    public int calPoints(String[] ops) {
        int length = ops.length;
        List<Integer> list = new ArrayList<>(length);
        for (String op : ops) {
            if (Objects.equals(op, "+")) {
                int size = list.size();
                list.add(list.get(size - 1) + list.get(size - 2));
            } else if (Objects.equals(op, "D")) {
                int size = list.size();
                list.add(list.get(size - 1) * 2);
            } else if (Objects.equals(op, "C")) {
                int size = list.size();
                list.remove(size - 1);
            } else {
                list.add(Integer.parseInt(op));
            }
        }
        int score = 0;
        for (Integer i : list) {
            score += i;
        }
        return score;
    }

    public static void main(String[] args) {
        CalPoints calPoints = new CalPoints();
        System.out.println(calPoints.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
