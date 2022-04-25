package algorithm.leetcode.easy.m;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    List<Integer> value;
    List<Integer> order;

    public MinStack() {
        value = new ArrayList<>();
        order = new ArrayList<>();
    }

    public void push(int val) {
        int size = value.size();
        value.add(val);
        if (size == 0) {
            order.add(val);
        } else if (size == 1){
            if (val > order.get(0)) {
                order.add(val);
            } else {
                order.add(0,val);
            }
        } else {
            if (val <= order.get(0)) {
                order.add(0,val);
            } else if (val >= order.get(size-1)) {
                order.add(val);
            } else {
                for (int i = 0; i < size - 1; i++) {
                    if (order.get(i) <= val && val < order.get(i+1)) {
                        order.add(i+1,val);
                    }
                }
            }

        }
    }

    public void pop() {
        int size = value.size();
        Integer v = value.get(size - 1);
        value.remove(size-1);
        order.remove(Integer.valueOf(v));
    }

    public int top() {
        int size = value.size();
        return value.get(size-1);
    }

    public int getMin() {
        return order.get(0);
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
