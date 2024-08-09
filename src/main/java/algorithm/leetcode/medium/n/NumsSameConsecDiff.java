package algorithm.leetcode.medium.n;

import java.util.ArrayList;
import java.util.List;

public class NumsSameConsecDiff {

    // 2 <= n <= 9
    // 0 <= k <= 9
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        // 第一个数字是 i
        for (int i = 1; i < 10; i++) {
            int prefix = i;
            int lastNum = i;
            for (int j = 0; j < k; j++) {

            }
        }
        return null;
    }

    public void addToList(int n, int k, int prefix, int prefixLength,
                          int lastNum, List<Integer> ans) {
        for (int i = prefixLength; i < k; i++) {
            
        }
    }
}
