package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.*;

// 查找一个有向网络的头节点和尾节点
public class FindHeadAndTail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(-1);
            return;
        }

        // 记录每个点的入度
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        // 记录每个点的后继点集合
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();

        // 记录图中点
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // 从 a 到 b 的路径
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 收集图中所有节点
            set.add(a);
            set.add(b);

            // b点入度+1
            inDegree.put(b, inDegree.getOrDefault(b, 0) + 1);

            // a点的后继点集合纳入b
            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b);
        }


        // 图中总共total个节点
        int total = set.size();

        // head记录图的头节点
        int head = 0;

        // 队列记录入度为0的点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int p : set) {
            // 题目描述中说图中只有一个首节点，首节点是入度为0的节点，因此如果某节点p没有入度，则为头节点
            if (!inDegree.containsKey(p)) {
                head = p;
                queue.add(p);
                break;
            }
        }

        // tails记录所有尾节点
        ArrayList<Integer> tails = new ArrayList<>();

        // count记录已被剥去的点个数，如果图中存在环，则必然最终count < total
        int count = 0;

        while (!queue.isEmpty()) {
            // 剥离入度为0的点
            int fa = queue.removeFirst();
            count++;

            // 如果fa没有后继点，即fa没有出度，则fa是尾节点
            if (!next.containsKey(fa)) {
                tails.add(fa);
                continue;
            }

            // 如果fa有后继点，则其所有后继点入度-1
            for (int ch : next.get(fa)) {
                inDegree.put(ch, inDegree.get(ch) - 1);

                // 如果ch点入度变为0，则加入队列
                if (inDegree.get(ch) == 0) {
                    queue.add(ch);
                }
            }
        }

        if (count != total) {
            // 如果存在环，则必然count < total
            System.out.println(-1);
        } else {
            // 如果不存在环，则打印头节点和尾节点
            StringJoiner sj = new StringJoiner(" ");

            sj.add(head + "");
            // 注意本题描述存在冲突（用例2输出的尾节点是从小到大排序的，而题目输出描述是要求尾节点从大到小排序），这里以用例为准
            tails.stream().sorted((a, b) -> a - b).forEach(p -> sj.add(p + ""));

            System.out.println(sj);
        }
    }
}
