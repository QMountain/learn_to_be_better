package algorithm.leetcode.medium.t;

import java.util.PriorityQueue;

public class TotalCost {

    // 1 <= costs.length <= 10^5
    // 1 <= costs[i] <= 10^5
    // 1 <= k, candidates <= costs.length
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0L;
        PriorityQueue<int[]> leftQueue = new PriorityQueue<>((a,b)-> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        PriorityQueue<int[]> rightQueue = new PriorityQueue<>((a,b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < candidates; i++) {
            leftQueue.add(new int[]{costs[i], i});
        }
        for (int i = costs.length-1; i >= Math.max(costs.length-candidates, candidates); i--) {
            rightQueue.add(new int[]{costs[i], i});
        }
        int leftIndex = candidates-1;
        int rightIndex = costs.length - candidates;
        while (k > 0) {
            k--;
            if (leftQueue.isEmpty()) {
                ans += rightQueue.poll()[0];
                if (rightIndex > leftIndex + 1) {
                    rightQueue.add(new int[]{costs[rightIndex-1], rightIndex-1});
                    --rightIndex;
                }
            } else if (rightQueue.isEmpty()) {
                ans += leftQueue.poll()[0];
                if (leftIndex + 1 < rightIndex) {
                    leftQueue.add(new int[]{costs[leftIndex+1], leftIndex+1});
                    leftIndex++;
                }
            } else {
                if (leftQueue.peek()[0] <= rightQueue.peek()[0]) {
                    ans += leftQueue.poll()[0];
                    if (leftIndex + 1 < rightIndex) {
                        leftQueue.add(new int[]{costs[leftIndex+1], leftIndex+1});
                        leftIndex++;
                    }
                } else {
                    ans += rightQueue.poll()[0];
                    if (rightIndex > leftIndex + 1) {
                        rightQueue.add(new int[]{costs[rightIndex-1], rightIndex-1});
                        --rightIndex;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        TotalCost totalCost = new TotalCost();
        System.out.println(223 == totalCost.totalCost(
                new int[]{18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75}, 13, 33));
        System.out.println(11 == totalCost.totalCost(
                new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58}, 11, 2));
        System.out.println(11 == totalCost.totalCost(
                new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
    }
}
