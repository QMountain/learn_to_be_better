package algorithm.leetcode.easy.o;

public class OddCells {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        int count = 0;
        for (int[] index : indices) {
            int x = index[0];
            int y = index[1];
            for (int i = 0; i < n; i++) {
                if (arr[x][i]++ % 2 == 0) {
                    count++;
                } else {
                    count--;
                }
            }
            for (int i = 0; i < m; i++) {
                if (arr[i][y]++ % 2 == 0) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count;
    }
    
}
