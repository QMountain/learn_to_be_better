package algorithm.leetcode.medium.m;

import java.util.*;

public class MaximumTastiness {

    // 2 <= k <= price.length <= 10^5
    // 1 <= price[i] <= 10^9
    public int maximumTastiness(int[] price, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : price) {
            set.add(i);
        }
        if (set.size() < k) {
            return 0;
        }
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (!set.isEmpty()) {
            sortedList.add(set.pollFirst());
        }
        return getMaxFromSortedList(sortedList, k, 0, sortedList.size()-1);
    }

    Map<String, Integer> map = new HashMap<>();

    public int getMaxFromSortedList(ArrayList<Integer> sortedList, int k, int left, int right) {
        if (right - left + 1 < k) {
            return -1;
        }
        int maxDistance = sortedList.get(right) - sortedList.get(left);
        if (k == 2) {
            return maxDistance;
        }
        int maxGrow = (maxDistance + k - 1) / (k-1);
        while (right - left >= 1) {
            if (sortedList.get(left+1) - sortedList.get(left) >= maxGrow) {
                left++;
                k--;
            } else {
                break;
            }
        }
        if (k == 2) {
            return sortedList.get(right) - sortedList.get(left);
        }
        while (right - left >= 1) {
            if (sortedList.get(right) - sortedList.get(right-1) >= maxGrow) {
                right--;
                k--;
            } else {
                break;
            }
        }
        if (k == 2) {
            return sortedList.get(right) - sortedList.get(left);
        }
        LinkedList<Integer> indexList = new LinkedList<>();
        indexList.addLast(left);
        for (int i = left+1; i <= right; i++) {
            if (sortedList.get(i) - sortedList.get(indexList.peekLast()) >= maxGrow) {
                indexList.addLast(i);
            }
        }

        /*while (true) {
            int res;
            String ke = sortedList.size() + "," + (k-1);
            if (map.containsKey(ke)) {
                res = map.get(ke);
            } else {
                res = getMaxFromSortedList(sortedList, k-1);
            }
            if (res == -1) {
                if (prefixList.size() < 2) {
                    return 0;
                }
                sortedList.addFirst(prefixList.pollLast());
            } else {
                if (sortedList.peekFirst() - prefixList.peekFirst() <= res) {
                    int v = sortedList.peekFirst() - prefixList.peekFirst();
                    while (!prefixList.isEmpty()) {
                        sortedList.addFirst(prefixList.pollLast());
                    }
                    String key = sortedList.size() + "," + k;
                    map.put(key, v);
                    return v;
                }
                if (sortedList.peekFirst() - prefixList.peekFirst() <= res) {
                    while (!prefixList.isEmpty()) {
                        sortedList.addFirst(prefixList.pollLast());
                    }
                    return res;
                } else {
                    sortedList.addFirst(prefixList.pollLast());
                }
            }
        }*/
        return 0;
    }

    public static void main(String[] args) {
        MaximumTastiness maximumTastiness = new MaximumTastiness();
        System.out.println(22 == maximumTastiness.maximumTastiness(
                new int[]{63,85,135,16,200,168,159,28}, 6));
        System.out.println(5 == maximumTastiness.maximumTastiness(
                new int[]{13,5,1,8,21,2}, 4));
        System.out.println(55 == maximumTastiness.maximumTastiness(
                new int[]{144,69,103,148,184,50,129,154,2}, 4));
        System.out.println(19 == maximumTastiness.maximumTastiness(
                new int[]{34,116,83,15,150,56,69,42,26}, 6));

        System.out.println(0 == maximumTastiness.maximumTastiness(
                new int[]{7,7,7,7}, 2));
        System.out.println(2 == maximumTastiness.maximumTastiness(
                new int[]{1,3,1}, 2));
        System.out.println(8 == maximumTastiness.maximumTastiness(
                new int[]{13,5,1,8,21,2}, 3));
    }
}
