package algorithm.leetcode.hard.g;

import java.util.*;

public class GetCoprimes {

    public LinkedList<int[]> initList(int node, int time) {
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{node, time});
        return list;
    }

    // 时间 13.95%  空间 85.27%
    public int[] getCoprimes(int[] nums, int[][] edges) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            LinkedList<Integer> list1 = map.getOrDefault(edge[0], new LinkedList<>());
            list1.add(edge[1]);
            map.put(edge[0], list1);

            LinkedList<Integer> list2 = map.getOrDefault(edge[1], new LinkedList<>());
            list2.add(edge[0]);
            map.put(edge[1], list2);
        }
        Map<String, Integer> cache = new HashMap<>();
        int[] ans = new int[nums.length];
        // 每个list 记录一种元素出现的时间点 0 节点号 1 时间点
        TreeSet<LinkedList<int[]>> queue = new TreeSet<>((a,b)-> b.peekLast()[1] - a.peekLast()[1]);
        // key 元素值 value 记录元素出现时间点的list
        HashMap<Integer, LinkedList<int[]>> elementMap = new HashMap<>();
        int time = 0;
        LinkedList<int[]> list = initList(0, time++);
        elementMap.put(nums[0], list);
        queue.add(list);
        // 深度优先搜索栈 0 节点号 1 元素值
        LinkedList<int[]> showedNodeQueue = new LinkedList<>();
        // 根节点从 0号节点开始
        showedNodeQueue.addLast(new int[]{0, nums[0]});
        while (!showedNodeQueue.isEmpty()) {
            // 栈顶节点
            Integer currNode = showedNodeQueue.peekLast()[0];
            LinkedList<Integer> children = map.get(currNode);
            Integer son = null;
            if (children != null) {
                while (!children.isEmpty()) {
                    Integer first = children.pollFirst();
                    if (showedNodeQueue.size() < 2 ||
                            first != showedNodeQueue.get(showedNodeQueue.size()-2)[0]) {
                        son = first;
                        break;
                    }
                }
            }
            // son 为空 代表当前节点是叶子节点
            if (son == null) {
                ans[currNode] = -1;
                // 将当前叶子节点出栈
                int[] polled = showedNodeQueue.pollLast();
                // 当前叶子节点 元素出现list
                LinkedList<int[]> elements = elementMap.get(polled[1]);
                // 队列出队再入队，实现重新排序
                queue.remove(elements);
                // poll掉最后的
                elements.pollLast();
                if (!elements.isEmpty()) {
                    queue.add(elements);
                } else {
                    // showList 为空则直接删掉整个entry
                    elementMap.remove(polled[1]);
                }
                // 互质祖先
                int primeNode = -1;
                for (LinkedList<int[]> linkedList : queue) {
                    if (currNode == 67) {
                        System.out.println("bug");
                    }
                    int node = linkedList.peekLast()[0];
                    if (gcd(nums[node], nums[currNode], cache) == 1) {
                        primeNode = node;
                        break;
                    }
                }
                ans[currNode] = primeNode;
                continue;
            }
            showedNodeQueue.addLast(new int[]{son, nums[son]});
            if (elementMap.containsKey(nums[son])) {
                LinkedList<int[]> old = elementMap.get(nums[son]);
                queue.remove(old);
                old.add(new int[]{son, time++});
                queue.add(old);
            } else {
                LinkedList<int[]> nl = initList(son, time++);
                elementMap.put(nums[son], nl);
                queue.add(nl);
            }
        }
        return ans;
    }

    public int[] getCoprimes2(int[] nums, int[][] edges) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            LinkedList<Integer> list1 = map.getOrDefault(edge[0], new LinkedList<>());
            list1.add(edge[1]);
            map.put(edge[0], list1);

            LinkedList<Integer> list2 = map.getOrDefault(edge[1], new LinkedList<>());
            list2.add(edge[0]);
            map.put(edge[1], list2);
        }
        Map<String, Integer> cache = new HashMap<>();
        int[] ans = new int[nums.length];
        HashSet<Integer> showedNodeSet = new HashSet<>();
        showedNodeSet.add(0);
        LinkedList<int[]> showedNodeQueue = new LinkedList<>();
        showedNodeQueue.addLast(new int[]{0, nums[0]});
        int time = 0;
        HashMap<Integer, LinkedList<Integer>> elementShowedMap = new HashMap<>();
        LinkedList<Integer> timeList = new LinkedList<>();
        timeList.addLast(time++);
        elementShowedMap.put(nums[0], timeList);
        while (!showedNodeQueue.isEmpty()) {
            Integer currNode = showedNodeQueue.peekLast()[0];
            LinkedList<Integer> children = map.get(currNode);
            Integer son = null;
            if (children != null) {
                while (!children.isEmpty()) {
                    Integer first = children.pollFirst();
                    if (!showedNodeSet.contains(first)) {
                        son = first;
                        break;
                    }
                }
            }
            if (son == null) {
                ans[currNode] = -1;
                int[] polled = showedNodeQueue.pollLast();
                showedNodeSet.remove(polled[0]);
                LinkedList<Integer> oldList = elementShowedMap.get(polled[1]);
                if (oldList.size() > 1) {
                    oldList.pollLast();
                } else {
                    elementShowedMap.remove(polled[1]);
                }
                time--;
                int latestTime = -1;
                for (Map.Entry<Integer, LinkedList<Integer>> entry : elementShowedMap.entrySet()) {
                    Integer element = entry.getKey();
                    if (gcd(element, nums[currNode], cache) == 1) {
                        latestTime = Math.max(latestTime, entry.getValue().peekLast());
                    }
                }
                if (latestTime != -1) {
                    ans[currNode] = showedNodeQueue.get(latestTime)[0];
                }
                continue;
            }
            showedNodeSet.add(son);
            showedNodeQueue.addLast(new int[]{son, nums[son]});
            LinkedList<Integer> list = elementShowedMap.getOrDefault(nums[son], new LinkedList<>());
            list.add(time++);
            elementShowedMap.put(nums[son], list);
        }
        return ans;
    }

    public int gcd(int a, int b, Map<String, Integer> cache) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return min;
        }
        String key = min + "," + max;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int gcd = gcd(min, max % min, cache);
        cache.put(key, gcd);
        return gcd;
    }

    public static void main(String[] args) {
        GetCoprimes getCoprimes = new GetCoprimes();
        System.out.println(Arrays.toString(getCoprimes.getCoprimes(
                new int[]{36,49,26,50,23,41,1,33,7,8,26,14,43,49,21,36,2,11,33,8,34,20,11,12,39,46,4,47,31,33,38,39,13,14,1,5,4,44,3,13,25,34,2,40,35,4,13,37,12,26,27,5,7,1,42,44,41,43,43,8,50,8,44,40,11,1,17,34,25,8,14,9,19,6,44,38,49,50,27,50,25,10,1,41,30,5,26,38,6,48,40,13,11,44,44,14,48,16,3,24,4,26,36,7,35,50,34,32},
                new int[][]{{99,0},{64,99},{91,64},{55,91},{94,0},{37,94},{58,37},{10,58},{6,10},{56,10},{45,56},{36,45},{40,45},{49,56},{101,49},{39,37},{69,39},{30,69},{34,30},{71,39},{98,39},{31,98},{22,31},{102,22},{3,98},{107,3},{50,107},{18,50},{16,18},{85,107},{15,85},{67,107},{42,67},{72,67},{12,67},{79,12},{53,79},{41,53},{68,53},{59,53},{78,59},{5,59},{105,5},{103,105},{24,79},{70,24},{4,70},{33,70},{54,70},{13,70},{46,13},{74,46},{93,74},{90,93},{1,90},{32,1},{52,1},{38,90},{57,38},{95,90},{14,95},{75,14},{66,75},{97,95},{2,97},{86,97},{25,97},{100,25},{61,100},{8,61},{104,93},{80,104},{82,104},{19,74},{81,19},{62,81},{87,81},{48,87},{77,48},{51,77},{7,81},{63,7},{27,63},{26,63},{28,26},{84,7},{11,84},{20,7},{89,20},{92,20},{76,92},{44,92},{83,44},{65,19},{47,65},{60,47},{23,60},{43,23},{21,43},{17,21},{35,23},{9,35},{29,9},{73,29},{88,60},{96,65},{106,19}}
        )));
        System.out.println(Arrays.toString(getCoprimes.getCoprimes(
                new int[]{2, 3, 3, 2},
                new int[][]{{0, 1}, {1, 2}, {1, 3}})));
        System.out.println(Arrays.toString(getCoprimes.getCoprimes(
                new int[]{9,16,30,23,33,35,9,47,39,46,16,38,5,49,21,44,17,1,6,37,49,15,23,46,38,9,27,3,24,1,14,17,12,23,43,38,12,4,8,17,11,18,26,22,49,14,9},
                new int[][]{{17,0},{30,17},{41,30},{10,30},{13,10},{7,13},{6,7},{45,10},{2,10},{14,2},{40,14},{28,40},{29,40},{8,29},{15,29},{26,15},{23,40},{19,23},{34,19},{18,23},{42,18},{5,42},{32,5},{16,32},{35,14},{25,35},{43,25},{3,43},{36,25},{38,36},{27,38},{24,36},{31,24},{11,31},{39,24},{12,39},{20,12},{22,12},{21,39},{1,21},{33,1},{37,1},{44,37},{9,44},{46,2},{4,46}}
        )));

        System.out.println(Arrays.toString(getCoprimes.getCoprimes(
                new int[]{9,16,30,23,33,35,9,47,39,46,16,38,5,49,21,44,17,1,6,37,49,15,23,46,38,9,27,3,24,1,14,17,12,23,43,38,12,4,8,17,11,18,26,22,49,14,9},
                new int[][]{{17,0},{30,17},{41,30},{10,30},{13,10},{7,13},{6,7},{45,10},{2,10},{14,2},{40,14},{28,40},{29,40},{8,29},{15,29},{26,15},{23,40},{19,23},{34,19},{18,23},{42,18},{5,42},{32,5},{16,32},{35,14},{25,35},{43,25},{3,43},{36,25},{38,36},{27,38},{24,36},{31,24},{11,31},{39,24},{12,39},{20,12},{22,12},{21,39},{1,21},{33,1},{37,1},{44,37},{9,44},{46,2},{4,46}}
        )));
        System.out.println(Arrays.toString(getCoprimes.getCoprimes(
                new int[]{5,6,10,2,3,6,15},
                new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}})));

    }
}
