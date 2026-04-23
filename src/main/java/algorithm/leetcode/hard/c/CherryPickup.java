package algorithm.leetcode.hard.c;

import java.util.Arrays;

public class CherryPickup {

    /**
     * 741. 摘樱桃
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        // f[x1][x2] 表示两个人分别到达 (x1, y1) 和 (x2, y2) 时的最大樱桃数
        // 其中 y1 = k - x1, y2 = k - x2, k 是步数
        int[][] f = new int[n][n];
        
        // 初始化为最小值，表示不可达
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        
        // 起点
        f[0][0] = grid[0][0];
        
        // 遍历所有可能的步数
        for (int k = 1; k < n * 2 - 1; ++k) {
            // 遍历所有可能的 x1 和 x2
            for (int x1 = Math.min(k, n - 1); x1 >= Math.max(k - n + 1, 0); --x1) {
                for (int x2 = Math.min(k, n - 1); x2 >= x1; --x2) {
                    int y1 = k - x1;
                    int y2 = k - x2;
                    
                    // 如果有障碍物，则不可达
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        f[x1][x2] = Integer.MIN_VALUE;
                        continue;
                    }
                    
                    // 从四个可能的前一个状态转移过来
                    int res = f[x1][x2]; // 都往右
                    if (x1 > 0) {
                        res = Math.max(res, f[x1 - 1][x2]); // 往下，往右
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[x1][x2 - 1]); // 往右，往下
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[x1 - 1][x2 - 1]); // 都往下
                    }
                    
                    // 加上当前位置的樱桃
                    res += grid[x1][y1];
                    if (x2 != x1) { // 避免重复摘同一个樱桃
                        res += grid[x2][y2];
                    }
                    
                    f[x1][x2] = res;
                }
            }
        }
        
        // 返回最终的最大值，如果不可达则返回0
        return Math.max(f[n - 1][n - 1], 0);
    }

    public static void main(String[] args) {
        CherryPickup cherryPickup = new CherryPickup();
        
        // 测试用例1：复杂网格
        System.out.println("测试用例1结果: " + cherryPickup.cherryPickup(new int[][]{
            {1,1,1,1,-1,-1,-1,1,0,0},
            {1,0,0,0,1,0,0,0,1,0},
            {0,0,1,1,1,1,0,1,1,1},
            {1,1,0,1,1,1,0,-1,1,1},
            {0,0,0,0,1,-1,0,0,1,-1},
            {1,0,1,1,1,0,0,-1,1,0},
            {1,1,0,1,0,0,1,0,1,-1},
            {1,-1,0,1,0,0,0,1,-1,1},
            {1,0,-1,0,-1,0,0,1,0,0},
            {0,0,-1,0,1,0,1,0,0,1}
        }));
        
        // 测试用例2：中等难度网格
        System.out.println("测试用例2结果: " + cherryPickup.cherryPickup(new int[][]{
            {0,1,1,0,0},
            {1,1,1,1,0},
            {-1,1,1,1,-1},
            {0,1,1,1,0},
            {1,0,-1,0,0}
        }));
        
        // 测试用例3：小网格
        System.out.println("测试用例3结果: " + cherryPickup.cherryPickup(new int[][]{
            {0, 1, -1},
            {1, 0, -1},
            {1, 1,  1}
        }));
        
        // 测试用例4：网格中有樱桃
        System.out.println("测试用例4结果: " + cherryPickup.cherryPickup(new int[][]{
            {1,1,1,1,0,0,0},
            {0,0,0,1,0,0,0},
            {0,0,0,1,0,0,1},
            {1,0,0,1,0,0,0},
            {0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0},
            {0,0,0,1,1,1,1}
        }));
        
        // 测试用例5：只有起点和终点有樱桃
        System.out.println("测试用例5结果: " + cherryPickup.cherryPickup(new int[][]{
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        }));
        
        // 测试用例6：无法到达终点
        System.out.println("测试用例6结果: " + cherryPickup.cherryPickup(new int[][]{
            {1, 0, 0},
            {0, -1, 0},
            {0, 0, 1}
        }));
    }
}
