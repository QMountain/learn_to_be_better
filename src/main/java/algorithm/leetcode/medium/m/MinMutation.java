package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        return minMutation(start,end,set);
    }

    public int minMutation(String start, String end, Set<String> bank) {
        if (start.equals(end)) {
            return 0;
        }
        char[] chars = start.toCharArray();
        for (int i = 0; i < 8; i++) {
            char startChar = start.charAt(i);
            char endChar = end.charAt(i);
            if (startChar != endChar) {
                chars[i] = endChar;
                String newStart = new String(chars);
                if (bank.contains(newStart)) {
                    int mm = minMutation(newStart, end, bank);
                    if (mm != -1) {
                        return mm +1;
                    }
                } else {
                    chars[i] = startChar;
                }
            }
        }
        int min = -1;
        char[] es = end.toCharArray();
        for (String s : bank) {
            char[] bs = s.toCharArray();
            int diff = 0;
            for (int i = 0; i < 8; i++) {
                if (es[i] != bs[i]) {
                    diff++;
                }
            }
            if (diff == 1) {
                Set<String> newBank = new HashSet<>(bank);
                newBank.remove(s);
                int i = minMutation(start, s, newBank);
                if (i != -1) {
                    if (min == -1) {
                        min = i+1;
                    } else {
                        min = Math.min(min,i+1);
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinMutation minMutation = new MinMutation();
        System.out.println(minMutation.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"}));
        System.out.println(minMutation.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
        System.out.println(minMutation.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }
}
