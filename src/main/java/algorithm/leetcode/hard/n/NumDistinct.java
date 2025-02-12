package algorithm.leetcode.hard.n;

import java.util.*;

public class NumDistinct {

    int divider = 1000_000_007;

    // 1 <= s.length, t.length <= 1000
    // s 和 t 由英文字母组成
    public int numDistinct(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        // 匹配上几个
        int[][] dp = new int[s.length()][t.length()+1];
        if (s.charAt(0) == t.charAt(0)) {
            dp[0][1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            System.arraycopy(dp[i-1], 0, dp[i], 0, t.length()+1);
            List<Integer> list = map.get(c);
            if (list == null) {
                continue;
            }
            for (Integer tIndex : list) {
                if (dp[i-1][tIndex] > 0) {
                    dp[i][tIndex+1] += dp[i-1][tIndex];
                }
                if (tIndex == 0) {
                    dp[i][1]++;
                }
            }
        }
        return dp[s.length()-1][t.length()];
        /*List<List<Integer>> indexList = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            List<Integer> list = new ArrayList<>();
            char tChar = t.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == tChar) {
                    list.add(j);
                }
            }
            indexList.add(list);
        }
        if (t.length() == 1) {
            return indexList.get(0).size();
        }
        int ans = 0;
        int row = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(indexList.get(0).size()-1);
        while (true) {
            // curr index
            Integer currIndex = indexList.get(row).get(stack.peek());

            List<Integer> nextRow = indexList.get(row + 1);
            if (row+1 == indexList.size()-1) {
                for (int i = 0; i < nextRow.size(); i++) {
                    if (nextRow.get(i) > currIndex) {
                        ans += nextRow.size() - i;
                        break;
                    }
                }
            } else {
                // get next row col from big to small
                int nextRowCol = -1;
                for (int i = nextRow.size()-1; i >= 0; i--) {
                    if (nextRow.get(i) > currIndex) {
                        nextRowCol = i;
                        break;
                    }
                }
                if (nextRowCol != -1) {
                    row++;
                    stack.push(nextRowCol);
                    continue;
                }
            }

            while (true) {
                Integer pop = stack.pop();
                if (pop == 0) {
                    if (row == 0) {
                        return ans;
                    }
                    row--;
                    continue;
                }
                if (row == 0) {
                    stack.push(pop-1);
                    break;
                }
                List<Integer> list = indexList.get(row);
                if (list.get(pop-1) < indexList.get(row-1).get(stack.peek())) {
                    row--;
                } else {
                    stack.push(pop-1);
                    break;
                }
            }
        }*/
    }

    public static void main(String[] args) {
        NumDistinct numDistinct = new NumDistinct();
        System.out.println(6 == numDistinct.numDistinct("anacondastreetracecar", "contra"));
        System.out.println(3 == numDistinct.numDistinct("rabbbit", "rabbit"));
        System.out.println(5 == numDistinct.numDistinct("babgbag", "bag"));
    }
}
