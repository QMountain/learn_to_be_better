package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.*;

// 电脑病毒感染
public class ComputerVirusInfection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 邻接表
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); // 出发点
            int v = sc.nextInt(); // 目标点
            int w = sc.nextInt(); // 出发点到达目标点的耗时

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }

        // 源点
        int src = sc.nextInt();

        // visited[i]:记录节点i是否找到最短路
        boolean[] visited = new boolean[n + 1];

        // dist[i]:记录源点到节点i的最短路
        int[] dist = new int[n + 1];
        // 初始时，假设源点不可达其他剩余点，即源点到达其他点的耗时无限大
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 源点到自身的耗时为0
        dist[src] = 0;

        // pq用于记录[节点编号，节点到源点的距离]，排序规则是，节点到源点的距离越短，优先级越高
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // 从源点src开始发起探索
        pq.add(new int[]{src, dist[src]});

        // bfs
        while (!pq.isEmpty()) {
            // 取出局部最优（最短）路径的终点编号 u
            int u = pq.poll()[0];

            // 如果节点编号u已经找到了最短路，说明当前u是重复入队的点，因此无需继续探索
            if (visited[u]) continue;
            // 否则记录当前u找到了最短路
            visited[u] = true;

            // 如果u有可达的其他点
            if (graph.containsKey(u)) {
                for (int[] next : graph.get(u)) {
                    // v是可达的其他店
                    // w是u->v的耗时
                    int v = next[0], w = next[1];

                    // 那么如果从源点到u点的耗时是dist[u]，那么源点经过u点到v点的耗时就是dist[u] + w
                    int newDist = dist[u] + w;
                    // 而源点到v的耗时之前是dist[v]，因此如果newDist < dist[v]，则找到更少耗时的路径
                    if (dist[v] > newDist) {
                        // 更新源点到v的路径，即更新v点权重
                        dist[v] = newDist;
                        // 将v点加入优先队列中参与下一轮局部最优路径比较
                        pq.add(new int[]{v, dist[v]});
                    }
                }
            }
        }

        // dist记录的是源点到达其他各点的最短耗时，我们取出其中最大的就是源点走完所有点的最短耗时
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        // 如果存在某个点无法到达，则源点到该点的耗时为Integer.MAX_VALUE
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
