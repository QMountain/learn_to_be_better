package algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return check(n,set);
    }

    public boolean check(int n, Set<Integer> set) {
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        String s = String.valueOf(n);
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != '0') {
                int num = Integer.parseInt(s.charAt(i) + "");
                sum += num*num;
            }
        }
        if (sum == 1) {
            return true;
        }
        return check(sum,set);
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(2));
        System.out.println(isHappy.isHappy(19));
        System.out.println(isHappy.isHappy(2));
    }
}
