package algorithm.leetcode.medium.c;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int countZero = 0;
        for (int num : nums) {
            String str = String.valueOf(num);
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length/2; i++) {
                char c = chars[i];
                chars[i] = chars[chars.length-1-i];
                chars[chars.length-1-i] = c;
            }
            int value = Integer.parseInt(new String(chars));
            if (value == num) {
                countZero++;
            } else {
                Integer oldCount = map.getOrDefault(value - num, 0);
                map.put(value-num, oldCount+1);
            }
        }
        long bcs = 1000_000_007L;
        long ans = 0;
        if (countZero > 1) {
            if (countZero % 2 == 0) {
                ans += ((countZero/2 % bcs) * ((countZero - 1L) % bcs)) % bcs;
            } else {
                ans += (((countZero - 1L) / 2 % bcs) * (countZero % bcs)) % bcs;
            }

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > 1) {
                if (value % 2 == 0) {
                    ans += ((value/2 % bcs) * ((value - 1L) % bcs)) % bcs;
                } else {
                    ans += (((value - 1L)/2 % bcs) * (value % bcs))% bcs;
                }
            }
        }
        return (int) (ans % bcs);
    }

    public static void main(String[] args) {
        CountNicePairs countNicePairs = new CountNicePairs();
        System.out.println(4 == countNicePairs.countNicePairs(new int[]{13,10,35,24,76}));
        System.out.println(2 == countNicePairs.countNicePairs(new int[]{42,11,1,97}));
    }
}
