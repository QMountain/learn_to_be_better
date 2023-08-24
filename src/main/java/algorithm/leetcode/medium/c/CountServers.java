package algorithm.leetcode.medium.c;

import java.util.HashMap;

public class CountServers {

    public int countServers(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    String keyX = "x" + i;
                    map.put(keyX, map.getOrDefault(keyX, 0) + 1);
                    String keyY = "y" + j;
                    map.put(keyY, map.getOrDefault(keyY, 0) + 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    String keyX = "x" + i;
                    String keyY = "y" + j;
                    if (map.get(keyX) > 1) {
                        count++;
                    } else if (map.get(keyY) > 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountServers countServers = new CountServers();
        System.out.println(4 == countServers.countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
        System.out.println(3 == countServers.countServers(new int[][]{{1,0},{1,1}}));
        System.out.println(0 == countServers.countServers(new int[][]{{1,0},{0,1}}));
    }
}
