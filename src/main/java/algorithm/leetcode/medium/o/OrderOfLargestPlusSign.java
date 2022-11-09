package algorithm.leetcode.medium.o;

public class OrderOfLargestPlusSign {

    int[][] grid;
    int n;

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n == 1) {
            return mines.length == 0 ? 1 : 0;
        }
        this.grid = new int[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = Math.min(Math.min(Math.min(i+1,j+1),n-i),n-j);
            }
        }
        for (int[] mine : mines) {
            cut(mine);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max,grid[i][j]);
            }
        }
        return max;
    }

    public void cut(int[] mine) {
        int mx = mine[0];
        int my = mine[1];
        grid[mx][my] = 0;
        // 与 mine 同行的中心点
        // my left
        for (int i = 0; i < my; i++) {
            grid[mx][i] = Math.min(grid[mx][i],Math.min(Math.min(Math.min(mx+1,i+1),n-i),my-i));
        }
        // my right
        for (int i = my+1; i < n; i++) {
            grid[mx][i] = Math.min(grid[mx][i],Math.min(Math.min(Math.min(mx+1,i-my),n-i),n-i));
        }
        // 与 mine 同列的中心点
        // mx up
        for (int i = 0; i < mx; i++) {
            grid[i][my] = Math.min(grid[i][my],Math.min(Math.min(Math.min(i+1,my+1),mx-i),n-my));
        }
        // mx down
        for (int i = mx+1; i < n; i++) {
            grid[i][my] = Math.min(grid[i][my],Math.min(Math.min(Math.min(i-mx,my+1),n-i),n-my));
        }
    }

    public static void main(String[] args) {
        OrderOfLargestPlusSign orderOfLargestPlusSign = new OrderOfLargestPlusSign();
        System.out.println(1 == orderOfLargestPlusSign.orderOfLargestPlusSign(2, new int[][]{{0,0},{0,1},{1,0}}));
        System.out.println(0 == orderOfLargestPlusSign.orderOfLargestPlusSign(1, new int[][]{{0,0}}));
        System.out.println(2 == orderOfLargestPlusSign.orderOfLargestPlusSign(5, new int[][]{{4,2}}));
    }
}
