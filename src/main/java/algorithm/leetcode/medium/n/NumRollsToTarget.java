package algorithm.leetcode.medium.n;

import java.util.HashMap;
import java.util.LinkedList;

public class NumRollsToTarget {

    HashMap<String, Long> map = new HashMap<>();
    HashMap<String, Integer> cMap = new HashMap<>();

    int divider = 1000_000_007;
    // 1 <= n, k <= 30
    // 1 <= target <= 1000
    public int numRollsToTarget(int n, int k, int target) {
        String key = n + "," + k + "," + target;
        if (map.containsKey(key)) {
            return Integer.parseInt(map.get(key).toString());
        }
        if (n == 1) {
            return k >= target ? 1 : 0;
        }
        if (k == 1) {
            return n == target ? 1 : 0;
        }
        if (n * k < target) {
            return 0;
        }
        // 最多有多少个k
        int maxKCount = (target - n) / (k - 1);
        // 最少有多少个k
        int minKCount;
        if ((k - 1) * n >= target) {
            minKCount = 0;
        } else {
            minKCount = target - ((k - 1) * n);
        }
        long sum = 0;
        for (int i = minKCount; i <= maxKCount; i++) {
            long ways = calC(n, i);
            if (ways < 0) {
                System.out.println("ways "+ways);
            }
            int rolls = numRollsToTarget(n - i, k - 1, target - (i * k));
            sum += rolls * ways % divider;
            if (sum < 0) {
                System.out.println("sum "+rolls);
            }
            sum %= divider;
        }
        map.put(key, sum);
        return (int)sum;
    }

    public int calC(int base, int select) {
        String key = base + "," + select;
        if (cMap.containsKey(key)) {
            return cMap.get(key);
        }
        LinkedList<Integer> fzList = new LinkedList<>();
        for (int i = base - select + 1; i <= base; i++) {
            fzList.add(i);
        }
        LinkedList<Integer> fmList = new LinkedList<>();
        for (int i = 2; i <= select; i++) {
            fmList.add(i);
        }
        while (true) {
            int fzIndex = -1;
            int fmIndex = -1;
            for (int i = 0; i < fzList.size(); i++) {
                for (int j = 0; j < fmList.size(); j++) {
                    if (fzList.get(i) % fmList.get(j) == 0) {
                        fzIndex = i;
                        fmIndex = j;
                        break;
                    }
                }
                if (fzIndex != -1) {
                    break;
                }
            }
            if (fzIndex == -1) {
                break;
            }
            fzList.addLast(fzList.get(fzIndex) / fmList.get(fmIndex));
            fzList.remove(fzIndex);
            fmList.remove(fmIndex);
        }
        long res = 1L;
        for (Integer fz : fzList) {
            res *= fz;
        }
        for (Integer fm : fmList) {
            res /= fm;
        }
        cMap.put(key, (int)res);
        return (int)res;
    }

    public static void main(String[] args) {
        NumRollsToTarget numRollsToTarget = new NumRollsToTarget();
        System.out.println(numRollsToTarget.numRollsToTarget(30, 30, 500));
        System.out.println(6 == numRollsToTarget.numRollsToTarget(2, 6, 7));
        System.out.println(1 == numRollsToTarget.numRollsToTarget(1, 6, 3));
    }
}
