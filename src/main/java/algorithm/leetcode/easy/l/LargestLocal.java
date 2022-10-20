package algorithm.leetcode.easy.l;

import java.util.*;

public class LargestLocal {

    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int[][] ans = new int[length-2][length-2];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                queue.add(grid[i][j]);
            }
        }
        List<PriorityQueue<Integer>> list = new LinkedList<>();
        list.add(queue);
        ans[0][0] = queue.peek();
        for (int i = 1; i < length - 2; i++) {
            PriorityQueue<Integer> nq = new PriorityQueue<>(list.get(i-1));
            for (int j = 0; j < 3; j++) {
                nq.remove(grid[i-1][j]);
                nq.add(grid[i+2][j]);
            }
            ans[i][0] = nq.peek();
            list.add(nq);
        }
        for (int i = 0; i < length - 2; i++) {
            PriorityQueue<Integer> nq = new PriorityQueue<>(list.get(i));
            for (int j = 1; j < length - 2; j++) {
                for (int k = 0; k < 3; k++) {
                    nq.remove(grid[i+k][j-1]);
                    nq.add(grid[i+k][j+2]);
                }
                ans[i][j] = nq.peek();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestLocal largestLocal = new LargestLocal();
        System.out.println(Arrays.deepToString(largestLocal.largestLocal(new int[][]{{20,8,20,6,16,16,7,16,8,10},{12,15,13,10,20,9,6,18,17,6},{12,4,10,13,20,11,15,5,17,1},{7,10,14,14,16,5,1,7,3,11},{16,2,9,15,9,8,6,1,7,15},{18,15,18,8,12,17,19,7,7,8},{19,11,15,16,1,3,7,4,7,11},{11,6,5,14,12,18,3,20,14,6},{4,4,19,6,17,12,8,8,18,8},{19,15,14,11,11,13,12,6,16,19}})));
        System.out.println(Arrays.deepToString(largestLocal.largestLocal(new int[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}})));
        System.out.println(Arrays.deepToString(largestLocal.largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}})));
    }
}
