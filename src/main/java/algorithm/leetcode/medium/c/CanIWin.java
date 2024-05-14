package algorithm.leetcode.medium.c;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

    // num+","+desire
    Map<String, Boolean> map = new HashMap<>();

    // 1 <= maxChoosableInteger <= 20
    // 0 <= desiredTotal <= 300
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 第一次就能赢
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        // 全拿完也不够就算输
        if (sum < desiredTotal) {
            return false;
        }
        int num = (1 << (maxChoosableInteger)) - 1;
        return canWin(num, sum, desiredTotal);
    }

    public boolean canWin(int num, int sum, int desired) {
        String key = num+","+desired;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        String binaryString = Integer.toBinaryString(num);
        int maxCanChoose = binaryString.length();
        // 拿个最大的就能赢
        if (maxCanChoose >= desired) {
            map.put(key, true);
            return true;
        }
        // 全拿完也不够就算输
        if (sum < desired) {
            map.put(key, false);
            return false;
        }
        for (int i = 0; i < maxCanChoose; i++) {
            if (binaryString.charAt(maxCanChoose - 1 - i) == '1') {
                int xor = num ^ (1 << i);
                String binaryString1 = Integer.toBinaryString(xor);
                if (!canWin(xor, sum-i-1, desired-i-1)) {
                    map.put(key, true);
                    return true;
                }
            }
        }
        map.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(10, 54));
        System.out.println(canIWin.canIWin(5, 50));
        System.out.println(canIWin.canIWin(10, 40));
        System.out.println(canIWin.canIWin(10, 11));
    }
}
