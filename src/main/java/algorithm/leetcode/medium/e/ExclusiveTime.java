package algorithm.leetcode.medium.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<String> stack = new Stack<>();
        stack.push(logs.get(0));

        int size = logs.size();
        int totalLast = 0;
        for (int i = 1; i < size; i++) {
            if (stack.size() > 0) {
                String[] split = stack.peek().split(":");
                int lastFunc = Integer.parseInt(split[0]);
                int lastStatus = split[1].equals("start") ? 0 : 1;
                int lastTime = Integer.parseInt(split[2]);

                String[] strings = logs.get(i).split(":");
                int currFunc = Integer.parseInt(strings[0]);
                int currStatus = strings[1].equals("start") ? 0 : 1;
                int currTime = Integer.parseInt(strings[2]);

                if (currStatus == 0) {
                    if (lastStatus == 0 && lastTime == totalLast) {
                        ans[lastFunc] += currTime - totalLast;
                    } else {
                        ans[lastFunc] += currTime - totalLast - 1;
                    }
                    stack.push(logs.get(i));
                } else {
                    if (totalLast == lastTime) {
                        ans[currFunc] += currTime - lastTime + 1;
                        stack.pop();
                    } else {
                        ans[lastFunc] += currTime - totalLast;
                        stack.pop();
                    }
                }
                totalLast = currTime;
            } else {
                stack.push(logs.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ExclusiveTime exclusiveTime = new ExclusiveTime();
        List<String> list5 = new ArrayList<>();
        list5.add("0:start:0");
        list5.add("0:end:0");
        list5.add("1:start:1");
        list5.add("1:end:1");
        list5.add("2:start:2");
        list5.add("2:end:2");
        list5.add("2:start:3");
        list5.add("2:end:3");
        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(3, list5)));

        List<String> list4 = new ArrayList<>();
        list4.add("0:start:0");
        list4.add("0:start:2");
        list4.add("0:end:5");
        list4.add("1:start:7");
        list4.add("1:end:7");
        list4.add("0:end:8");
        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(2, list4)));

        List<String> list3 = new ArrayList<>();
        list3.add("0:start:0");
        list3.add("0:start:2");
        list3.add("0:end:5");
        list3.add("1:start:6");
        list3.add("1:end:6");
        list3.add("0:end:7");
        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(2, list3)));

        List<String> list2 = new ArrayList<>();
        list2.add("0:start:0");
        list2.add("0:start:2");
        list2.add("0:end:5");
        list2.add("0:start:6");
        list2.add("0:end:6");
        list2.add("0:end:7");
        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(1, list2)));

        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("1:start:2");
        list.add("1:end:5");
        list.add("0:end:6");
        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(2, list)));
    }
}
