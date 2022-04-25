package algorithm.leetcode.easy.m;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private final List<Integer> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        int size = list.size();
        Integer integer = list.get(size - 1);
        list.remove(size-1);
        return integer;
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
