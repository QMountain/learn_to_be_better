package algorithm.leetcode.medium.q;

import java.util.ArrayList;
import java.util.TreeSet;

public class QueryString {

    public boolean queryString(String s, int n) {
        while (s.startsWith("0")) {
            s = s.substring(1);
        }
        if (s.equals("")) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) == '1' ? 1 : 0;
            set.add(num);
            for (int j = i+1; j < Math.min(s.length(), i+31); j++) {
                num = (num << 1) + (s.charAt(j) == '1' ? 1 : 0);
                set.add(num);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        int left = 0;
        int right = list.size()-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == n) {
                left = mid;
                break;
            }
            if (list.get(mid) > n) {
                right = mid;
            } else {
                if (left == mid) {
                    left = right;
                    break;
                }
                left = mid;
            }
        }
        if (list.get(left) != n) {
            return false;
        }
        if (list.get(0) == 0) {
            return left == n;
        }
        return left + 1 == n;
    }

    public static void main(String[] args) {
        QueryString queryString = new QueryString();
        System.out.println(queryString.queryString("0", 1));
        System.out.println(queryString.queryString("0101011001101101010001001111110111100110110001001111001111111011010010101001011111010010001011011011", 5));
        System.out.println(!queryString.queryString("0110", 4));
        System.out.println(queryString.queryString("0110", 3));
    }
}
