package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 5G网络建设
public class FiveGNetworkConstruction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 基站数量（节点数）
        int m = sc.nextInt(); // 基站对数量（边数）

        // 邻接矩阵
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 初始化默认各点之间互不联通，即i-j边权无限大
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int p = sc.nextInt();

            if (p == 0) {
                // x-y边权为z
                graph[x][y] = z;
                graph[y][x] = z;
            } else {
                // 对应已经联通的两点，可以理解为边权为0
                graph[x][y] = 0;
                graph[y][x] = 0;
            }
        }

        System.out.println(prim(graph, n));
    }

    public static int prim(int[][] graph, int n) {
        // 记录最小生成树的边权和
        int minWeight = 0;

        // inTree[i] 表示 节点i 是否在最小生成树中
        boolean[] inTree = new boolean[n + 1];

        // 初始时任选一个节点作为最小生成树的初始节点，这里选择节点1
        inTree[1] = true;
        // 记录最小生成树中点数量
        int inTree_count = 1;

        // dis[i]表示 节点i 到最小生成树集合 的最短距离
        int[] dis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 初始时，最小生成树集合中只有节点1，因此其他节点到最小生成树的距离，其实就是到节点1的距离
            dis[i] = graph[1][i];
        }

        // 如果最小生成树中点数量达到n个，则结束循环
        while (inTree_count < n) {
            // 现在我们需要从未纳入最小生成树的点中，找到一个距离最小生成树最近的

            // minDis 记录这个最近距离
            int minDis = Integer.MAX_VALUE;
            // idx 记录距离最小生成树minDis个距离的节点
            int nodeIdx = 0;

            for (int i = 1; i <= n; i++) {
                // 从未纳入最小生成树的点中，找到一个距离最小生成树最近的
                if (!inTree[i] && dis[i] < minDis) {
                    minDis = dis[i];
                    nodeIdx = i;
                }
            }

            // 如果nodeIdx == 0,则说明未纳入最小生成树的这些点到最小生成树的距离都是Integer.MAX_VALUE，即不与最小生成树存在关联
            if (nodeIdx == 0) {
                // 则说明，当前所有点无法形成最小生成树
                return -1;
            }

            inTree[nodeIdx] = true; // 最小生成树需要纳入最短距离点nodeIdx
            inTree_count++; // 最小生成树中点数量+1
            minWeight += dis[nodeIdx]; // 更新最小生成树的权重和

            // dis[i] 初始时记录的是节点i 到 节点1 的距离（初始的生成树中只有节点1）
            // 现在生成树纳入了新节点nodeIdx，则我们需要更新一下dis[i]，即有可能某些点到最小生成树中的nodeIdx点距离更近
            for (int i = 1; i <= n; i++) {
                if (!inTree[i] && graph[nodeIdx][i] < dis[i]) {
                    // 注意，这是一个累进过程，初始时dis[i]记录的是节点i到节点1的距离，
                    // 之后，最小生成树纳入新点后，如果节点i到新点的距离更近，则dis[i]就更新为这个更短距离
                    // 总之，dis[i] 记录的是 节点 i 到最小生成树的最短距离
                    dis[i] = graph[nodeIdx][i];
                }
            }
        }

        return minWeight;
    }
}
