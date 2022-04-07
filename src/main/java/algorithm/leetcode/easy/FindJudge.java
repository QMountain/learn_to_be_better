package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindJudge {

    public int findJudge(int n, int[][] trust) {
        int judge = -1;
        int length = trust.length;
        if (length == 0) {
            if (n == 1) {
                return 1;
            }
            return judge;
        }
        Map<Integer, List<Integer>> trustedMap = new HashMap<>(n);
        int[] trustOther = new int[n];
        for (int[] ints : trust) {
            int personIndex = ints[0]-1;
            trustOther[personIndex] = 1;
            int trustedPersonIndex = ints[1]-1;
            List<Integer> list = new ArrayList<>(trustedMap.getOrDefault(trustedPersonIndex,new ArrayList<>()));
            list.add(personIndex);
            trustedMap.put(trustedPersonIndex,list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : trustedMap.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() == n-1) {
                Integer key = entry.getKey();
                if (trustOther[key] == 0) {
                    return key+1;
                }
            }
        }
        return judge;
    }

    public static void main(String[] args) {
        FindJudge findJudge = new FindJudge();
        System.out.println(2 == findJudge.findJudge(2, new int[][]{{1, 2}}));
        System.out.println(3 == findJudge.findJudge(3, new int[][]{{1, 3},{2,3}}));
    }
}
