package algorithm.leetcode.medium.r;

import java.util.*;

public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        System.out.println(Arrays.deepToString(reconstructQueue.reconstructQueue(
                new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}})));
        System.out.println(Arrays.deepToString(reconstructQueue.reconstructQueue(
                new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}})));
    }
}
