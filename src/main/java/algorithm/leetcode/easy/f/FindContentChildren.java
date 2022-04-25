package algorithm.leetcode.easy.f;

import java.util.Arrays;

public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sLen = s.length;
        int res = 0;
        int index = 0;
        for (int k : g) {
            for (int j = index; j < sLen; j++) {
                if (s[j] >= k) {
                    res++;
                    index = j + 1;
                    break;
                }
            }
        }
        return res;
    }

}
