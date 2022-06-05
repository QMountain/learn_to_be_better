package algorithm.leetcode.medium.l;

import java.util.*;

public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task,map.getOrDefault(task,0)+1);
        }
        int size = map.size();
        int[][] arr = new int[size][2];
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        for (int i = 0; i < size; i++) {
            Map.Entry<Character, Integer> entry = entries.get(i);
            int[] a = new int[2];
            a[0] = entry.getValue();
            a[1] = entry.getKey();
            arr[i] = a;
        }
        Arrays.sort(arr,(a,b)-> b[0]-a[0]);
        List<Integer> list = new ArrayList<>(n);
        int index = 0;
        int ans = 0;
        while (true) {
            if (!list.contains(arr[index][1]) && arr[index][0] > 0) {
                arr[index][0]--;
                list.add(arr[index][1]);
                if (index < size-1) {
                    index++;
                } else {
                    index = 0;
                }
            } else {
                int old = index;
                boolean empty = true;
                for (int i = index; i < size; i++) {
                    if (arr[i][0] > 0) {
                        empty = false;
                        if (!list.contains(arr[i][1])) {
                            index = i;
                            break;
                        }
                    }
                }
                if (index != old) {
                    continue;
                }
                for (int i = 0; i < index; i++) {
                    if (arr[i][0] > 0) {
                        empty = false;
                        if (!list.contains(arr[i][1])) {
                            index = i;
                            break;
                        }
                    }
                }
                if (index == old) {
                    list.add(-1);
                }
                if (empty) {
                    break;
                }
            }
            ans++;
            if (list.size() > n) {
                list.remove(0);
                index = 0;
                Arrays.sort(arr,(a,b)-> b[0]-a[0]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        System.out.println(12 == leastInterval.leastInterval(new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'}, 2));
        System.out.println(16 == leastInterval.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        System.out.println(8 == leastInterval.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
