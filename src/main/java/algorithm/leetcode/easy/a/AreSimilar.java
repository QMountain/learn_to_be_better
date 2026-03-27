package algorithm.leetcode.easy.a;

public class AreSimilar {

    /**
     * 2946. 循环移位后的矩阵相似检查
     * 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。
     * 请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
     * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
     */
    public boolean areSimilar(int[][] mat, int k) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return true;
        }
        
        int m = mat.length;
        int n = mat[0].length;
        
        // 创建变换后的矩阵
        int[][] transformed = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                // 偶数行左移k次
                for (int j = 0; j < n; j++) {
                    transformed[i][j] = mat[i][(j + k) % n];
                }
            } else {
                // 奇数行右移k次
                for (int j = 0; j < n; j++) {
                    transformed[i][j] = mat[i][(j - k % n + n) % n];
                }
            }
        }
        
        // 比较变换后的矩阵与原始矩阵是否相同
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != transformed[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        AreSimilar solution = new AreSimilar();
        
        // 测试用例1
        int[][] mat1 = {
            {1, 2, 1, 2},
            {5, 5, 5, 5},
            {6, 3, 6, 3}
        };
        System.out.println("测试用例1: " + solution.areSimilar(mat1, 2)); // 应该返回 true
        
        // 测试用例2
        int[][] mat2 = {
            {2, 2},
            {2, 2}
        };
        System.out.println("测试用例2: " + solution.areSimilar(mat2, 3)); // 应该返回 true
        
        // 测试用例3
        int[][] mat3 = {
            {1, 2}
        };
        System.out.println("测试用例3: " + solution.areSimilar(mat3, 1)); // 应该返回 false
        
        // 测试用例4
        int[][] mat4 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
        };
        System.out.println("测试用例4: " + solution.areSimilar(mat4, 5)); // 应该返回 true
        
        // 测试用例5 - 单行
        int[][] mat5 = {
            {1, 2, 3, 4, 5}
        };
        System.out.println("测试用例5: " + solution.areSimilar(mat5, 2)); // 应该返回 false
        
        // 测试用例6 - 单列
        int[][] mat6 = {
            {1},
            {2},
            {3},
            {4}
        };
        System.out.println("测试用例6: " + solution.areSimilar(mat6, 1)); // 应该返回 true
        
        // 测试用例7 - 空矩阵
        int[][] mat7 = {};
        System.out.println("测试用例7: " + solution.areSimilar(mat7, 1)); // 应该返回 true
        
        // 测试用例8 - 单行单列
        int[][] mat8 = {
            {5}
        };
        System.out.println("测试用例8: " + solution.areSimilar(mat8, 3)); // 应该返回 true
    }

}
