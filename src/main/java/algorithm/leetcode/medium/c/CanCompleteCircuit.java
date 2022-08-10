package algorithm.leetcode.medium.c;

import java.util.Arrays;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int totalNeed = Arrays.stream(cost).sum();
        if (totalGas < totalNeed) {
            return -1;
        }
        int gl = gas.length;
        if (gl == 0) {
            return 0;
        }
        for (int i = 0; i < gl; i++) {
            if (gas[i] != cost[i] || i == gl-1) {
                int sumGas = 0;
                int sumCost = 0;
                boolean complete = true;
                for (int j = i; j < gl; j++) {
                    sumGas += gas[j];
                    sumCost += cost[j];
                    if (sumGas < sumCost) {
                        complete = false;
                        break;
                    }
                }
                if (!complete) {
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    sumGas += gas[j];
                    sumCost += cost[j];
                    if (sumGas < sumCost) {
                        complete = false;
                        break;
                    }
                }
                if (complete) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        System.out.println(canCompleteCircuit.canCompleteCircuit(new int[]{2}, new int[]{2}));
        System.out.println(canCompleteCircuit.canCompleteCircuit(new int[]{5,1,2,3,4},
                new int[]{4,4,1,5,1}));
        System.out.println(canCompleteCircuit.canCompleteCircuit(new int[]{2,3,4},
                new int[]{3,4,3}));
        System.out.println(canCompleteCircuit.canCompleteCircuit(new int[]{1,2,3,4,5},
                new int[]{3,4,5,1,2}));
    }
}
