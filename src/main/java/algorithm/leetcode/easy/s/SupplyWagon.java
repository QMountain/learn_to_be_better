package algorithm.leetcode.easy.s;

import java.util.*;

public class SupplyWagon {

    public int[] supplyWagon(int[] supplies) {
        int length = supplies.length;
        int targetLen = length / 2;
        for (int i = 0; i < length - targetLen; i++) {
            int minIndex = 0;
            for (int j = 1; j < length - 1 - i; j++) {
                if (supplies[j] + supplies[j+1] <
                        supplies[minIndex] + supplies[minIndex+1]) {
                    minIndex = j;
                }
            }
            supplies[minIndex] += supplies[minIndex+1];
            System.arraycopy(supplies, minIndex+2, supplies, minIndex+1, length-2-i-minIndex);
        }
        return Arrays.copyOf(supplies, targetLen);
    }

    // 2 <= supplies.length <= 1000
    public int[] supplyWagon2(int[] supplies) {
        int length = supplies.length;
        int targetLen = length / 2;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < length - 1; i++) {
            queue.add(supplies[i] + supplies[i+1]);
            list.add(supplies[i]);
        }
        list.add(supplies[length-1]);
        for (int i = 0; i < length - targetLen; i++) {
            Integer poll = queue.poll();
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) + list.get(j+1) == poll) {
                    if (j > 0) {
                        queue.remove(list.get(j-1)+list.get(j));
                        queue.add(list.get(j-1) + poll);
                    }
                    if (j < list.size()-2) {
                        queue.remove(list.get(j+1)+list.get(j+2));
                        queue.add(list.get(j+2) + poll);
                    }
                    list.remove(j+1);
                    list.set(j, poll);
                    break;
                }
            }
        }
        int[] ans = new int[targetLen];
        for (int i = 0; i < targetLen; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        SupplyWagon supplyWagon = new SupplyWagon();
        System.out.println(Arrays.toString(supplyWagon.supplyWagon(
                new int[]{1, 3, 1, 5})).equals("[5, 5]"));
        System.out.println(Arrays.toString(supplyWagon.supplyWagon(
                new int[]{7, 3, 6, 1, 8})).equals("[10, 15]"));
    }
}
