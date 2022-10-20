package algorithm.leetcode.medium.g;

import java.util.HashMap;
import java.util.Map;

public class GetMoneyAmount {

    Map<String,Integer> map;

    // 题号375 猜数字大小II  虽然不是正常的dp，但是基本思想一样，而且复杂度也没高
    public int getMoneyAmount(int n) {
        if (n < 4) {
            return n-1;
        }
        this.map = new HashMap<>();
        int min = 1 + calAndPut(3,n);
        for (int i = 2; i <= n; i++) {
            int left = calAndPut(1,i-1);
            int right = calAndPut(i+1,n);
            int curr = Math.max(left,right)+i;
            min = Math.min(min,curr);
        }
        return min;
    }

    public int calAndPut(int from, int to) {
        if (from >= to) {
            return 0;
        }
        String key = from + "," + to;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (to - from < 3) {
            return from+(to-from-1);
        }
        if (to - from == 3) {
            return from*2+2;
        }
        int min = from + calAndPut(from+1,to);
        for (int i = 1; i <= to - from; i++) {
            int left = calAndPut(from,from+i-1);
            int right = calAndPut(from+i+1,to);
            min = Math.min(min,Math.max(left,right) + from + i);
        }
        map.put(key,min);
        return min;
    }

    public static void main(String[] args) {
        GetMoneyAmount getMoneyAmount = new GetMoneyAmount();
        System.out.println(64 == getMoneyAmount.getMoneyAmount(25));
        System.out.println(8 == getMoneyAmount.getMoneyAmount(6));
        System.out.println(16 == getMoneyAmount.getMoneyAmount(10));
        System.out.println(34 == getMoneyAmount.getMoneyAmount(16));

        System.out.println(0 == getMoneyAmount.getMoneyAmount(1));
        System.out.println(1 == getMoneyAmount.getMoneyAmount(2));
    }
}
