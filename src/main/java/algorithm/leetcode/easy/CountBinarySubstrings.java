package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int count = 0;
        int length = s.length();
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    list.add(j-i);
                    i = j-1;
                    break;
                } else if (j == length-1) {
                    list.add(j-i+1);
                    i = j;
                    break;
                }
            }
        }
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            Integer c1 = list.get(i);
            Integer c2 = list.get(i + 1);
            count += Math.min(c1,c2);
        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings("00100"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("100111001"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("00110011"));
    }
}
