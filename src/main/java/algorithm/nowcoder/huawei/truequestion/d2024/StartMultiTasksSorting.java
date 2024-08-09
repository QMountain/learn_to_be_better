package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.*;

// 启动多任务排序
public class StartMultiTasksSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] relations =
                Arrays.stream(sc.nextLine().split(" ")).map(s -> s.split("->")).toArray(String[][]::new);

        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, ArrayList<String>> next = new HashMap<>();

        for (String[] relation : relations) {
            // a依赖b, 即b执行完，才能执行a
            String a = relation[0];
            String b = relation[1];

            // b的入度不变
            inDegree.put(b, inDegree.getOrDefault(b, 0));
            // a的入度+1
            inDegree.put(a, inDegree.getOrDefault(a, 0) + 1);

            // b的后继节点集合添加a
            next.putIfAbsent(b, new ArrayList<>());
            next.get(b).add(a);
            // a的后继节点集合不变
            next.putIfAbsent(a, new ArrayList<>());
        }

        // queue收集第一层入度为0的点
        ArrayList<String> queue = new ArrayList<>();
        for (String task : inDegree.keySet()) {
            if (inDegree.get(task) == 0) {
                queue.add(task);
            }
        }

        // 记录任务执行的顺序
        StringJoiner ans = new StringJoiner(" ");

        while (queue.size() > 0) {
            // 如果同时有多个任务要执行，则根据任务名称字母顺序排序
            queue.sort(String::compareTo);

            // newQueue用于记录下一层入度为0的点
            ArrayList<String> newQueue = new ArrayList<>();

            for (String fa : queue) {
                // fa执行，则加入已完成的任务列表
                ans.add(fa);

                for (String ch : next.get(fa)) {
                    // fa是父任务，ch是子任务, 即fa执行完，才能执行ch
                    // fa执行完，则对应ch的入度-1
                    inDegree.put(ch, inDegree.get(ch) - 1);

                    // 如果ch的入度变为0，则加入新一层入度0的点集
                    if (inDegree.get(ch) == 0) {
                        newQueue.add(ch);
                    }
                }
            }

            queue = newQueue;
        }

        System.out.println(ans);
    }
}
