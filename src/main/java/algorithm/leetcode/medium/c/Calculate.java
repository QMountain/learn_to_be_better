package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculate {

    List<String> list;

    public int calculate(String s) {
        list = new ArrayList<>();
        String[] splitMulti = s.split("\\*");
        addMulti(splitMulti[0]);
        for (int i = 1; i < splitMulti.length; i++) {
            list.add("*");
            addMulti(splitMulti[i]);
        }
        LinkedList<String> linkedList = new LinkedList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String s1 = list.get(i).trim();
            if (s1.equals("*") || s1.equals("/")) {
                int num1 = Integer.parseInt(linkedList.pollLast());
                int num2 = Integer.parseInt(list.get(++i));
                if (s1.equals("*")) {
                    linkedList.addLast(String.valueOf(num1*num2));
                } else {
                    linkedList.addLast(String.valueOf(num1/num2));
                }
            } else {
                linkedList.addLast(s1);
            }
        }
        while (linkedList.size() > 1) {
            int num1 = Integer.parseInt(linkedList.pollFirst());
            if (linkedList.peekFirst().equals("+")) {
                linkedList.pollFirst();
                int num2 = Integer.parseInt(linkedList.pollFirst());
                linkedList.addFirst(String.valueOf(num1+num2));
            } else if (linkedList.peekFirst().equals("-")) {
                linkedList.pollFirst();
                int num2 = Integer.parseInt(linkedList.pollFirst());
                linkedList.addFirst(String.valueOf(num1-num2));
            }
        }
        return Integer.parseInt(linkedList.pop());
    }

    public void addMulti(String s) {
        String[] splitDivide = s.split("/");
        addDivide(splitDivide[0].trim());
        for (int i = 1; i < splitDivide.length; i++) {
            list.add("/");
            addMulti(splitDivide[i].trim());
        }
    }

    public void addDivide(String s) {
        String[] splitPlus = s.split("\\+");
        addPlus(splitPlus[0].trim());
        for (int i = 1; i < splitPlus.length; i++) {
            list.add("+");
            addPlus(splitPlus[i].trim());
        }
    }

    public void addPlus(String s) {
        String prefix = "";
        if (s.startsWith("-")) {
            prefix = "-";
            s = s.substring(1);
        }
        String[] split = s.split("-");
        list.add(prefix + split[0]);
        for (int i = 1; i < split.length; i++) {
            list.add("-");
            list.add(split[i]);
        }
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(5 == calculate.calculate(" 3+5 / 2 "));
        System.out.println(3 == calculate.calculate("2-3+4"));
        System.out.println(1 == calculate.calculate("1-1+1"));
        System.out.println(-2147483647 == calculate.calculate("0-2147483647"));

        System.out.println(1 == calculate.calculate(" 3/2 "));
        System.out.println(7 == calculate.calculate("3+2*2"));
    }
}
