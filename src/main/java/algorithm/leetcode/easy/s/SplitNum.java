package algorithm.leetcode.easy.s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitNum {

    // 10 <= num <= 10^9
    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num >= 10) {
            list.add(num % 10);
            num /= 10;
        }
        list.add(num);
        Collections.sort(list);
        int num1 = list.get(0);
        if (list.size() % 2 == 0) {
            for (int i = 2; i < list.size(); i+=2) {
                num1 = num1 * 10 + list.get(i);
            }
            int num2 = list.get(1);
            for (int i = 3; i < list.size(); i+=2) {
                num2 = num2 * 10 + list.get(i);
            }
            return num1 + num2;
        }
        for (int i = 1; i < list.size(); i+=2) {
            num1 = num1 * 10 + list.get(i);
        }
        int num2 = list.get(2);
        for (int i = 4; i < list.size(); i+=2) {
            num2 = num2 * 10 + list.get(i);
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
        SplitNum splitNum = new SplitNum();
        System.out.println(75 == splitNum.splitNum(687));
        System.out.println(59 == splitNum.splitNum(4325));
    }
}
