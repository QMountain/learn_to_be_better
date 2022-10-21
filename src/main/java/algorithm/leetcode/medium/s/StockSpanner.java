package algorithm.leetcode.medium.s;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class StockSpanner {

    LinkedList<Integer> elementList;
    LinkedList<Integer> countList;

    // 题号 901 股票价格跨度 官解 单调栈 时间O(n) 空间O(n)
    Deque<int[]> stack;
    int idx;

    public StockSpanner() {
        elementList = new LinkedList<>();
        countList = new LinkedList<>();

        // 官解 单调栈
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }

    public int next2(int price) {
        if (elementList.isEmpty() || elementList.peekLast() > price) {
            elementList.add(price);
            countList.add(1);
            return 1;
        }
        Integer count = countList.peekLast();
        for (int i = countList.size()-1-count; i >= 0; i--) {
            if (elementList.get(i) <= price) {
                Integer currCount = countList.get(i);
                count += currCount;
                i -= currCount-1;
            } else {
                break;
            }
        }
        count++;
        elementList.add(price);
        countList.add(count);
        return count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
