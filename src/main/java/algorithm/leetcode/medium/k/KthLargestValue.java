package algorithm.leetcode.medium.k;

import java.util.PriorityQueue;

public class KthLargestValue {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        queue.add(matrix[0][0]);
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                matrix[0][i] = matrix[0][i-1] ^ matrix[0][i];
                queue.add(matrix[0][i]);
            }
        }
        if (m > 1) {
            for (int i = 1; i < m; i++) {
                matrix[i][0] = matrix[i - 1][0] ^ matrix[i][0];
                queue.add(matrix[i][0]);
            }
        }
        if (m > 1 && n > 1) {
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = matrix[i-1][j] ^ matrix[i][j-1] ^ matrix[i-1][j-1] ^ matrix[i][j];
                    queue.add(matrix[i][j]);
                }
            }
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestValue kthLargestValue = new KthLargestValue();
        System.out.println(kthLargestValue.kthLargestValue(
                new int[][]{{8,10,5,8,5,7,6,0,1,4,10,6,4,3,6,8,7,9,4,2}}, 2));
        System.out.println(kthLargestValue.kthLargestValue(
                new int[][]{{5,2},{1,6}}, 2));
    }
}
