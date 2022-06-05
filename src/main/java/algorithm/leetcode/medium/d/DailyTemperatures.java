package algorithm.leetcode.medium.d;

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] arr = new int[length];
        LinkedList<int[]> linkedList = new LinkedList<>();
        int[] p = new int[2];
        p[0] = temperatures[length-1];
        p[1] = length-1;
        linkedList.push(p);
        for (int i = length-2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i+1]) {
                arr[i] = 1;
                int[] p1 = new int[2];
                p1[0] = temperatures[i];
                p1[1] = i;
                linkedList.push(p1);
            } else {
                while (linkedList.peek()[0] <= temperatures[i]) {
                    linkedList.pop();
                    if (linkedList.isEmpty()) {
                        break;
                    }
                }
                if (!linkedList.isEmpty()) {
                    arr[i] = linkedList.peek()[1]-i;
                }
                int[] p1 = new int[2];
                p1[0] = temperatures[i];
                p1[1] = i;
                linkedList.push(p1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
