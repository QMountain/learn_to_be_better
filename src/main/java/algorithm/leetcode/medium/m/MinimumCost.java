package algorithm.leetcode.medium.m;

public class MinimumCost {

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
        System.out.println(8 == minimumCost.minimumCost("000010000"));
        System.out.println(1 == minimumCost.minimumCost("000000001"));
        System.out.println(2 == minimumCost.minimumCost("0011"));
        System.out.println(9 == minimumCost.minimumCost("010101"));
    }
}
