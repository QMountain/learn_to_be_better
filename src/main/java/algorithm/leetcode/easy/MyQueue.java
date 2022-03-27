package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private final List<Integer> list;

    public MyQueue() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        Integer integer = list.get(0);
        list.remove(0);
        return integer;
    }

    public int peek() {
        return list.get(0);
    }

    public boolean empty() {
        return list.size() == 0;
    }

}
