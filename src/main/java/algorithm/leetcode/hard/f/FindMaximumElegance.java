package algorithm.leetcode.hard.f;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindMaximumElegance {

    // 1 <= items.length == n <= 10^5
    // items[i].length == 2
    // items[i][0] == profiti
    // items[i][1] == categoryi
    // 1 <= profiti <= 10^9
    // 1 <= categoryi <= n
    // 1 <= k <= n
    public long findMaximumElegance(int[][] items, int k) {
        long ans = 0L;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int[] item = items[i];
            int profit = item[0];
            int category = item[1];
            int oldCategories = map.size();
            PriorityQueue<Integer> queue = map.getOrDefault(category, new PriorityQueue<>());
            queue.add(profit);
            map.put(category, queue);

            ans += profit;
            if (oldCategories < map.size()) {
                ans -= (long) oldCategories * oldCategories;
                ans += (long) map.size() * map.size();
            }
        }
        for (int i = k; i < items.length; i++) {
            int[] item = items[i];
            int profit = item[0];
            int category = item[1];
            // method 1：顶掉自身种类中最小profit的
            int m1 = 0;
            if (map.containsKey(category)) {
                PriorityQueue<Integer> queue = map.get(category);
                Integer peek = queue.peek();
                if (profit > peek) {
                    m1 = profit - peek;
                }
            }
            int oldCategories = map.size();
            // method 2：顶掉重复种类中最小profit的
            int dupMinProfit = -1;
            int dupMinCategory = -1;
            // method 3：顶掉单个种类中最小profit的
            int singleMinProfit = -1;
            int singleMinCategory = -1;
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
                Integer currCategory = entry.getKey();
                if (currCategory == category) {
                    continue;
                }
                PriorityQueue<Integer> queue = entry.getValue();
                if (queue.size() > 1) {
                    if (dupMinProfit == -1 || queue.peek() < dupMinProfit) {
                        dupMinProfit = queue.peek();
                        dupMinCategory = currCategory;
                    }
                } else {
                    if (singleMinProfit == -1 || queue.peek() < singleMinProfit) {
                        singleMinProfit = queue.peek();
                        singleMinCategory = currCategory;
                    }
                }
            }
            int grow1 = 0;
            if (dupMinCategory != -1) {
                grow1 += profit - dupMinProfit;
                grow1 -= oldCategories * oldCategories;
                grow1 += (oldCategories + 1) * (oldCategories + 1);
            }
            int grow2 = 0;
            if (singleMinProfit != -1) {
                grow2 += profit - singleMinProfit;
            }
            if (grow1 > 0 || grow2 > 0) {
                if (grow2 >= grow1) {
                    ans += grow2;
                    map.remove(singleMinCategory);
                } else {
                    ans += grow1;
                    map.get(dupMinCategory).poll();
                }
                PriorityQueue<Integer> q = new PriorityQueue<>();
                q.add(profit);
                map.put(category, q);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMaximumElegance findMaximumElegance = new FindMaximumElegance();
        System.out.println(17 == findMaximumElegance.findMaximumElegance(
                new int[][]{{2,2},{8,3},{8,3}}, 2));
        System.out.println(19 == findMaximumElegance.findMaximumElegance(
                new int[][]{{3,1},{3,1},{2,2},{5,3}}, 3));
        System.out.println(17 == findMaximumElegance.findMaximumElegance(
                new int[][]{{3,2},{5,1},{10,1}}, 2));
    }
}
