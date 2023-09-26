package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SequenceReconstruction {

    // n == nums.length
    // 1 <= n <= 10^4
    // nums 是 [1, n] 范围内所有整数的排列
    // 1 <= sequences.length <= 10^4
    // 1 <= sequences[i].length <= 10^4
    // 1 <= sum(sequences[i].length) <= 10^5
    // 1 <= sequences[i][j] <= n
    // sequences 的所有数组都是 唯一 的
    // sequences[i] 是 nums 的一个子序列
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        List<HashSet<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<>());
        }
        for (int[] sequence : sequences) {
            int sl = sequence.length;
            for (int i = 0; i < sl-1; i++) {
                int index = sequence[i] - 1;
                list.get(index).add(sequence[i+1]);
            }
        }
        for (HashSet<Integer> set : list) {
            if (set.isEmpty()) {
                return false;
            }
            if (set.size() > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        System.out.println(sequenceReconstruction.sequenceReconstruction(
                new int[]{4, 1, 5, 2, 6, 3},
                new int[][]{{5,2,6,3},{4,1,5,2}}));
        System.out.println(!sequenceReconstruction.sequenceReconstruction(new int[]{1, 2, 3},
                new int[][]{{1,2},{1,3}}));
    }
}
