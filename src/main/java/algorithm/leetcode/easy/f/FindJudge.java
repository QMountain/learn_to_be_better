package algorithm.leetcode.easy.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindJudge {

    // 1 <= n <= 1000
    // 0 <= trust.length <= 10^4
    // trust[i].length == 2
    // trust 中的所有trust[i] = [ai, bi] 互不相同
    // ai != bi
    // 1 <= ai, bi <= n
    public int findJudge(int n, int[][] trust) {
        int length = trust.length;
        if (length == 0) {
            if (n == 1) {
                return 1;
            }
            return -1;
        }
        // 第 0 列是count多少人信任自己，-1代表自己信任了别人，不能是法官
        int[][] record = new int[n][n+1];
        for (int[] arr : trust) {
            // 人的编号
            int peopleNumber = arr[0];
            record[peopleNumber-1][0] = -1;
            if (record[arr[1]-1][0] == -1) {
                continue;
            }
            if (record[arr[1]-1][arr[0]] == 0) {
                record[arr[1]-1][arr[0]] = 1;
                record[arr[1]-1][0]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (record[i][0] == n-1) {
                return i+1;
            }
        }
        return -1;
    }

    public int findJudge2(int n, int[][] trust) {
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
        System.out.println(3 == findJudge.findJudge(4,
                new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
        System.out.println(2 == findJudge.findJudge(2,
                new int[][]{{1, 2}}));
        System.out.println(3 == findJudge.findJudge(3, new int[][]{{1, 3},{2,3}}));
    }
}
