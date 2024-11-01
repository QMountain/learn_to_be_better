package algorithm.leetcode.medium.m;

import java.math.BigInteger;
import java.util.*;

public class MaxTotalReward {

    // 1 <= rewardValues.length <= 2000
    // 1 <= rewardValues[i] <= 2000
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        BigInteger f = BigInteger.ONE;
        for (int x : rewardValues) {
            BigInteger mask = BigInteger.ONE.shiftLeft(x).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(x));
        }
        return f.bitLength() - 1;
    }

    public int maxTotalReward2(int[] rewardValues) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int rewardValue : rewardValues) {
            set.add(rewardValue);
        }
        int ceiling = set.pollLast() - 1;
        TreeSet<Integer> sum = new TreeSet<>();
        sum.add(0);
        while (!set.isEmpty()) {
            Integer num = set.pollFirst();
            TreeSet<Integer> next = new TreeSet<>();
            next.add(0);
            for (Integer i : sum) {
                next.add(i);
                if (i < num) {
                    int v = i + num;
                    if (v <= ceiling) {
                        next.add(v);
                        if (v == ceiling) {
                            return ceiling + ceiling + 1;
                        }
                    }
                }
            }
            sum = next;
        }
        return sum.last() + ceiling + 1;
    }

    public static void main(String[] args) {
        MaxTotalReward maxTotalReward = new MaxTotalReward();
        System.out.println(35 == maxTotalReward.maxTotalReward(new int[]{7,8,3,20}));
        System.out.println(35 == maxTotalReward.maxTotalReward(new int[]{2,15,14,18}));
        System.out.println(11 == maxTotalReward.maxTotalReward(new int[]{1,6,4,3,2}));
        System.out.println(4 == maxTotalReward.maxTotalReward(new int[]{1,1,3,3}));
    }

}
