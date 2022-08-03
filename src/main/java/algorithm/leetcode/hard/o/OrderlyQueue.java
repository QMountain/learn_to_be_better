package algorithm.leetcode.hard.o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderlyQueue {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            char minChar = s.charAt(0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < minChar) {
                    minChar = s.charAt(i);
                }
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == minChar) {
                    list.add(s.substring(i)+s.substring(0,i));
                }
            }
            String min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (min.compareTo(list.get(i)) > 0) {
                    min = list.get(i);
                }
            }
            return min;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        OrderlyQueue orderlyQueue = new OrderlyQueue();
        System.out.println(orderlyQueue.orderlyQueue("baaca", 3));
        System.out.println(orderlyQueue.orderlyQueue("cba", 1));
    }
}
