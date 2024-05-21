package algorithm.leetcode.medium.f;

import java.util.*;

public class FindWinners {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            int[] arr1 = map.getOrDefault(winner, new int[2]);
            arr1[0]++;
            map.put(winner, arr1);

            int[] arr2 = map.getOrDefault(loser, new int[2]);
            arr2[1]++;
            map.put(loser, arr2);
        }
        List<Integer> noLoseList = new ArrayList<>();
        List<Integer> oneLoseList = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] winAndLose = entry.getValue();
            int win = winAndLose[0];
            int lose = winAndLose[1];
            if (win + lose > 0) {
                if (lose == 0) {
                    noLoseList.add(entry.getKey());
                } else if (lose == 1) {
                    oneLoseList.add(entry.getKey());
                }
            }
        }
        Collections.sort(noLoseList);
        Collections.sort(oneLoseList);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(noLoseList);
        ans.add(oneLoseList);
        return ans;
    }

    public static void main(String[] args) {
        FindWinners findWinners = new FindWinners();
        System.out.println(findWinners.findWinners(
                new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }
}
