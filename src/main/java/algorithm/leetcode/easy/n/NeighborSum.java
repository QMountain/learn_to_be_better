package algorithm.leetcode.easy.n;

import java.util.HashMap;
import java.util.Map;

public class NeighborSum {

    Map<Integer, Integer> aMap = new HashMap<>();
    Map<Integer, Integer> dMap = new HashMap<>();

    public NeighborSum(int[][] grid) {
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int key = grid[i][j];
                int aSum = 0;
                if (i > 0) {
                    aSum += grid[i-1][j];
                }
                if (i < length-1) {
                    aSum += grid[i+1][j];
                }
                if (j > 0) {
                    aSum += grid[i][j-1];
                }
                if (j < length-1) {
                    aSum += grid[i][j+1];
                }
                aMap.put(key, aSum);
                int dSum = 0;
                if (i > 0) {
                    if (j > 0) {
                        dSum += grid[i-1][j-1];
                    }
                    if (j < length-1) {
                        dSum += grid[i-1][j+1];
                    }
                }
                if (i < length-1) {
                    if (j > 0) {
                        dSum += grid[i+1][j-1];
                    }
                    if (j < length-1) {
                        dSum += grid[i+1][j+1];
                    }
                }
                dMap.put(key, dSum);
            }
        }
    }

    public int adjacentSum(int value) {
        return aMap.get(value);
    }

    public int diagonalSum(int value) {
        return dMap.get(value);
    }

}
