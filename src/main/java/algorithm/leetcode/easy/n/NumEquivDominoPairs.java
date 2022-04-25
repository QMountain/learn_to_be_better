package algorithm.leetcode.easy.n;

import java.util.HashMap;
import java.util.Map;

public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<String,Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            String s;
            if (a <= b) {
                s = a + "," + b;
            } else {
                s = b + "," + a;
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value >= 2) {
                res += value*(value-1)/2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumEquivDominoPairs numEquivDominoPairs = new NumEquivDominoPairs();
        System.out.println(numEquivDominoPairs.numEquivDominoPairs(
                new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}}));
        System.out.println(numEquivDominoPairs.numEquivDominoPairs(new int[][]{{1,2},{2,1},{3,4},{5,6}}));
    }
}
