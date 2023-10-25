package algorithm.leetcode.medium.p;

import java.util.TreeMap;

public class PunishmentNumber {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int punishmentNumber(int n) {
        int from;
        int to;
        int base;
        if (map.isEmpty()) {
            from = 1;
            to = n;
            base = 0;
        } else {
            if (map.lastKey() >= n) {
                return map.lowerEntry(n + 1).getValue();
            } else {
                from = map.lastKey();
                to = n;
                base = map.lastEntry().getValue();
            }
        }
        for (int i = from; i <= to; i++) {
            int sum = i * i;
            if (match(String.valueOf(i), String.valueOf(sum))) {
                base += sum;
                map.put(i, base);
            }
        }
        map.put(n, base);
        return base;
    }

    public boolean match(String i, String sum) {
        int subMaxLen = i.length();
        if (sum.length() == subMaxLen) {
            return i.equals(sum);
        } else if (sum.length() < subMaxLen) {
            return false;
        }
        for (int j = 1; j < subMaxLen; j++) {
            String substring = sum.substring(0, j);
            int left = Integer.parseInt(substring);
            int right = Integer.parseInt(i) - left;
            String leftStr = sum.substring(j);
            if (match(String.valueOf(right), leftStr)) {
                return true;
            }
        }
        String substring = sum.substring(0, subMaxLen);
        if (substring.compareTo(i) > 0) {
            return false;
        } else if (substring.compareTo(i) == 0) {
            return Integer.parseInt(sum.substring(subMaxLen)) == 0;
        }
        int left = Integer.parseInt(substring);
        int right = Integer.parseInt(i) - left;
        String leftStr = sum.substring(subMaxLen);
        return match(String.valueOf(right), leftStr);
    }

    public static void main(String[] args) {
        PunishmentNumber punishmentNumber = new PunishmentNumber();
        System.out.println(1478 == punishmentNumber.punishmentNumber(37));
        System.out.println(182 == punishmentNumber.punishmentNumber(10));
    }
}
