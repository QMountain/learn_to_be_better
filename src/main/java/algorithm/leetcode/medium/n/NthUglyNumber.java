package algorithm.leetcode.medium.n;

import java.util.*;

public class NthUglyNumber {

    // 官解2 dp  O(n)
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public int nthUglyNumber2(int n) {
        if (n < 7) {
            return n;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(n,(a,b)->b-a);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        while (list.size() > 0) {
            if (queue.size() >= n && list.get(0)*2 > queue.peek()) {
                break;
            }
            List<Integer> nList = new ArrayList<>();
            for (Integer i : list) {
                if (i > Integer.MAX_VALUE/2) {
                    continue;
                }
                if (!set.contains(i*2)) {
                    if (queue.size() < n) {
                        queue.add(i*2);
                        nList.add(i*2);
                        set.add(i*2);
                    } else if (i*2 < queue.peek()) {
                        queue.poll();
                        queue.add(i*2);
                        nList.add(i*2);
                        set.add(i*2);
                    }
                }
                if (i > Integer.MAX_VALUE/3) {
                    continue;
                }
                if (!set.contains(i*3)) {
                    if (queue.size() < n) {
                        queue.add(i*3);
                        nList.add(i*3);
                        set.add(i*3);
                    } else if (i*3 < queue.peek()) {
                        queue.poll();
                        queue.add(i*3);
                        nList.add(i*3);
                        set.add(i*3);
                    }
                }
                if (i > Integer.MAX_VALUE/5) {
                    continue;
                }
                if (!set.contains(i*5)) {
                    if (queue.size() < n) {
                        queue.add(i*5);
                        nList.add(i*5);
                        set.add(i*5);
                    } else if (i*5 < queue.peek()) {
                        queue.poll();
                        queue.add(i*5);
                        nList.add(i*5);
                        set.add(i*5);
                    }
                }
            }
            list = nList;
        }

        return queue.peek();
    }


    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(1600));
        System.out.println(1 == nthUglyNumber.nthUglyNumber(1));
        System.out.println(12 == nthUglyNumber.nthUglyNumber(10));
        System.out.println(nthUglyNumber.nthUglyNumber(396));
        System.out.println(nthUglyNumber.nthUglyNumber(600));
        System.out.println(nthUglyNumber.nthUglyNumber(900));
        System.out.println(nthUglyNumber.nthUglyNumber(1352));



    }
}
