package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.HashSet;
import java.util.Scanner;

// 小华最多能得到多少克黄金
public class GetGold {

    static int m;
    static int n;
    static int k;

    // 记录题解
    static int ans = 0;

    // 记录已访问过的位置，避免重复统计
    static HashSet<Integer> visited = new HashSet<>();

    // 上下左右偏移量
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 数位和数组
    static int[] digitSums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        digitSum(Math.max(m, n));

        dfs(0, 0);

        System.out.println(ans);
    }

    // 深度优先搜索遍历矩阵
    public static void dfs(int x, int y) {
        // 如果对应位置越界，或者已访问过，或者横坐标、纵坐标的数位和之和超过了k，则不能进入
        if (x < 0
                || x >= m
                || y < 0
                || y >= n
                || visited.contains(x * n + y)
                || digitSums[x] + digitSums[y] > k) return;

        // 否则可以进入，且获得黄金
        visited.add(x * n + y);
        ans++;

        // 继续遍历上、下、左、右方向上的新位置继续深搜
        for (int[] offset : offsets) {
            int newX = x + offset[0];
            int newY = y + offset[1];

            dfs(newX, newY);
        }
    }

    // 该方法用于求解 0 ~ maxSize - 1 各个数对应的数位和，提前计算好，避免后期重复计算某个数的数位和
    public static void digitSum(int maxSize) {
        // digitSums数组的索引是原始数，值是原始数对应的数位和
        digitSums = new int[maxSize];

        for (int i = 0; i < maxSize; i++) {
            int num = i;
            while (num > 0) {
                digitSums[i] += num % 10;
                num /= 10;
            }
        }
    }
}
