package algorithm.leetcode.hard.m;

import java.util.*;

public class MaximumInvitations {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        // 统计入度，便于进行拓扑排序
        int[] indeg = new int[n];
        for (int k : favorite) {
            ++indeg[k];
        }
        boolean[] used = new boolean[n];
        int[] f = new int[n];
        Arrays.fill(f, 1);
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            used[u] = true;
            int v = favorite[u];
            // 状态转移
            f[v] = Math.max(f[v], f[u] + 1);
            --indeg[v];
            if (indeg[v] == 0) {
                queue.offer(v);
            }
        }
        // ring 表示最大的环的大小
        // total 表示所有环大小为 2 的「基环内向树」上的最长的「双向游走」路径之和
        int ring = 0, total = 0;
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                int j = favorite[i];
                // favorite[favorite[i]] = i 说明环的大小为 2
                if (favorite[j] == i) {
                    total += f[i] + f[j];
                    used[i] = used[j] = true;
                }
                // 否则环的大小至少为 3，我们需要找出环
                else {
                    int u = i, cnt = 0;
                    while (true) {
                        ++cnt;
                        u = favorite[u];
                        used[u] = true;
                        if (u == i) {
                            break;
                        }
                    }
                    ring = Math.max(ring, cnt);
                }
            }
        }
        return Math.max(ring, total);
    }

    // 两种形式
    // 1. 环状依赖，取最大环即可
    // 2. 多组非环状依赖 加和
    // 其中第二种，每组有两个互相依赖的人做核心，带周围人，相当于计算以他俩为根节点的树高和
    public int maximumInvitations2(int[] favorite) {
        int length = favorite.length;
        int maxCircleSize = 0;
        LinkedList<int[]> takeList = new LinkedList<>();
        boolean[] searched = new boolean[length];
        HashMap<Integer, HashSet<Integer>> takeMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            HashSet<Integer> s = takeMap.get(favorite[i]);
            if (s == null) {
                s = new HashSet<>();
            }
            s.add(i);
            takeMap.put(favorite[i], s);
            // 以 i 为起点，找 环 找到的环是个set
            // 把环set里的人都加入结果集，如果环set是两个，那个俩人都可以再额外带一个依赖各自的人
            // 如果环set大于2个人，那么不能再额外带人了
            // 把搜寻路径上的人都视为搜索过了，找下一个环的时候不能再走走过的路
            if (!searched[i]) {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                LinkedList<Integer> queue = new LinkedList<>();
                queue.addLast(i);
                boolean circle = false;
                while (true) {
                    Integer last = queue.peekLast();
                    if (searched[favorite[last]]) {
                        break;
                    }
                    if (set.contains(favorite[last])) {
                        circle = true;
                        queue.addLast(favorite[last]);
                        break;
                    } else {
                        set.add(favorite[last]);
                        queue.addLast(favorite[last]);
                    }
                }
                for (Integer q : queue) {
                    searched[q] = true;
                }
                if (circle) {
                    while (!Objects.equals(queue.peekFirst(), queue.peekLast())) {
                        queue.pollFirst();
                    }
                    queue.pollLast();
                    maxCircleSize = Math.max(maxCircleSize, queue.size());
                    if (queue.size() == 2) {
                        takeList.add(new int[]{queue.get(0), queue.get(1)});
                    }
                }
            }
        }
        int noCircleSum = 0;
        for (int[] take : takeList) {
            HashSet<Integer> removeSet = new HashSet<>();
            removeSet.add(take[0]);
            removeSet.add(take[1]);
            HashSet<Integer> set1 = new HashSet<>();
            set1.add(take[0]);
            int count = calTreeHeight(set1, removeSet, takeMap);
            HashSet<Integer> set2 = new HashSet<>();
            set2.add(take[1]);
            count += calTreeHeight(set2, removeSet, takeMap);
            noCircleSum += count;
        }
        return  Math.max(maxCircleSize, noCircleSum);
    }

    public int calTreeHeight(HashSet<Integer> rootSet, HashSet<Integer> removeSet,
                             HashMap<Integer, HashSet<Integer>> takeMap) {
        HashSet<Integer> ns = new HashSet<>();
        for (Integer root : rootSet) {
            HashSet<Integer> set = takeMap.get(root);
            if (set != null) {
                for (Integer i : set) {
                    if (!removeSet.contains(i)) {
                        ns.add(i);
                    }
                }
            }
        }
        if (ns.isEmpty()) {
            return 1;
        }
        return calTreeHeight(ns, removeSet, takeMap) + 1;
    }

    public static void main(String[] args) {
        MaximumInvitations maximumInvitations = new MaximumInvitations();
        System.out.println(11 == maximumInvitations.maximumInvitations(
                new int[]{1,0,3,2,5,6,7,4,9,8,11,10,11,12,10}));
        System.out.println(3 == maximumInvitations.maximumInvitations(
                new int[]{2,2,1,2}));
        System.out.println(6 == maximumInvitations.maximumInvitations(
                new int[]{1,0,0,2,1,4,7,8,9,6,7,10,8}));
        System.out.println(4 == maximumInvitations.maximumInvitations(
                new int[]{3,0,1,4,1}));
        System.out.println(3 == maximumInvitations.maximumInvitations(
                new int[]{1,2,0}));

    }
}
