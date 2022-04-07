package algorithm.leetcode.easy;

public class MaxCount {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m*n;
        }
        int minx = ops[0][0];
        int miny = ops[0][1];
        for (int[] op : ops) {
            minx = Math.min(minx,op[0]);
            miny = Math.min(miny,op[1]);
        }
        return minx*miny;
    }

}
