package algorithm.leetcode.medium.m;

public class MinimumCost {

    /**
     * 3789. 采购的最小花费
     * 1 <= cost1, cost2, costBoth <= 10^6
     * 0 <= need1, need2 <= 10^9
     */
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int combine = cost1 + cost2;
        if (combine <= costBoth) {
            return (long) cost1 * need1 + ((long) cost2 * need2);
        }
        if (need1 == need2) {
            return (long) costBoth * need1;
        }
        if (need1 > need2) {
            return (long) need2 * costBoth + ((long) (need1 - need2) * Math.min(cost1, costBoth));
        }
        return (long) need1 * costBoth + ((long) (need2 - need1) * Math.min(cost2, costBoth));
    }

    // 1 <= s.length == n <= 10^5
    // s[i] 为 '0' 或 '1'
    public long minimumCost(String s) {
        int length = s.length();
        if (length == 1) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = length - 1;
        long ans = 0L;
        while (true) {
            if (left == length - 2) {
                if (charArray[left] == charArray[length -1]) {
                    return ans;
                }
                return ans + 1;
            }
            while (charArray[left] == charArray[left+1]) {
                if (left + 1 == right) {
                    return ans;
                }
                left++;
            }
            while (charArray[right] == charArray[right-1]) {
                if (left + 1 == right) {
                    return ans;
                }
                right--;
            }
            int inverseLeftCost = left + 1;
            int inverseRightCost = length - right;
            if (left + 1 == right) {
                return ans + Math.min(inverseLeftCost, inverseRightCost);
            }
            if (inverseLeftCost <= inverseRightCost) {
                ans += inverseLeftCost;
                left++;
            } else {
                ans += inverseRightCost;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        MinimumCost minimumCost = new MinimumCost();
        System.out.println(0 == minimumCost.minimumCost(
                5, 4, 15, 0, 0));
        System.out.println(22 == minimumCost.minimumCost(
                5, 4, 15, 2, 3));
        System.out.println(3 == minimumCost.minimumCost(
                3, 2, 1, 3, 2));

        System.out.println(8 == minimumCost.minimumCost("000010000"));
        System.out.println(1 == minimumCost.minimumCost("000000001"));
        System.out.println(2 == minimumCost.minimumCost("0011"));
        System.out.println(9 == minimumCost.minimumCost("010101"));
    }
}
