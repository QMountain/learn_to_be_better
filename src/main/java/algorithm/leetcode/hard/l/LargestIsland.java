package algorithm.leetcode.hard.l;

import java.util.*;

public class LargestIsland {

    int[][] grid;
    // key: row + col  value: 岛屿编号
    Map<String,Integer> map;
    // key: islandNo  value: islandArea
    Map<Integer,Integer> islandNoAreaMap;
    int length;
    boolean[][] visited;
    int islandNo;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.map = new HashMap<>();
        this.islandNoAreaMap = new HashMap<>();
        this.length = grid.length;
        this.visited = new boolean[length][length];
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans,false);
        }
        this.islandNo = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 周围岛屿编号set
                Set<Integer> set = new HashSet<>();
                if (grid[i][j] == 0) {
                    // up
                    if (i > 0 && grid[i-1][j] == 1) {
                        Integer islandNo = map.get((i - 1) + "," + j);
                        set.add(islandNo);
                    }
                    // down
                    if (i < length-1 && grid[i+1][j] == 1) {
                        Integer islandNo = map.get((i + 1) + "," + j);
                        set.add(islandNo);
                    }
                    // left
                    if (j > 0 && grid[i][j-1] == 1) {
                        Integer islandNo = map.get(i + "," + (j-1));
                        set.add(islandNo);
                    }
                    // right
                    if (j < length-1 && grid[i][j+1] == 1) {
                        Integer islandNo = map.get(i + "," + (j+1));
                        set.add(islandNo);
                    }
                }
                if (set.isEmpty()) {
                    continue;
                }
                if (set.size() == 1) {
                    for (Integer no : set) {
                        ans = Math.max(ans,islandNoAreaMap.get(no)+1);
                    }
                }

                int area = 0;
                for (Integer no : set) {
                    area += islandNoAreaMap.get(no);
                }
                ans = Math.max(ans,area+1);
            }
        }
        if (islandNoAreaMap.size() == 1) {
            Integer area = islandNoAreaMap.get(1);
            if (area == length * length) {
                return area;
            }
        }
        return ans;
    }

    public void dfs(int i, int j) {
        dfsWithoutNoIncrease(i,j);
        islandNo++;
    }

    public void dfsWithoutNoIncrease(int i, int j) {
        map.put(i+","+j,islandNo);
        islandNoAreaMap.put(islandNo,islandNoAreaMap.getOrDefault(islandNo,0)+1);
        visited[i][j] = true;
        // up
        if (i > 0 && grid[i-1][j] == 1 && !visited[i-1][j]) {
            dfsWithoutNoIncrease(i-1,j);
        }
        // down
        if (i < length-1 && grid[i+1][j] == 1 && !visited[i+1][j]) {
            dfsWithoutNoIncrease(i+1,j);
        }
        // left
        if (j > 0 && grid[i][j-1] == 1 && !visited[i][j-1]) {
            dfsWithoutNoIncrease(i,j-1);
        }
        // right
        if (j < length-1 && grid[i][j+1] == 1 && !visited[i][j+1]) {
            dfsWithoutNoIncrease(i,j+1);
        }
    }

    public static void main(String[] args) {
        LargestIsland largestIsland = new LargestIsland();
        System.out.println(4 == largestIsland.largestIsland(new int[][]{{1,1},{1,1}}));
        System.out.println(4 == largestIsland.largestIsland(new int[][]{{1,1},{1,0}}));
        System.out.println(3 == largestIsland.largestIsland(new int[][]{{1,0},{0,1}}));
    }
}
