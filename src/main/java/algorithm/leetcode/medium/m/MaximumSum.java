package algorithm.leetcode.medium.m;

public class MaximumSum {

    // 输入边界： 1 <= arr.length <= 105
    // 执行结果，dp可以只便利一次，有待优化
    public int maximumSum(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return arr[0];
        }
        int maxElement = arr[0];
        int[] prefixMaxArr = new int[length];
        int sum = 0;
        for (int i = 1; i < length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            sum += arr[i - 1];
            if (sum < 0) {
                sum = 0;
            }
            prefixMaxArr[i] = Math.max(sum, arr[i-1]);
        }
        if (maxElement <= 0) {
            return maxElement;
        }
        int[] suffixMaxArr = new int[length];
        sum = 0;
        for (int i = length-2; i >= 0; i--) {
            sum += arr[i + 1];
            if (sum < 0) {
                sum = 0;
            }
            suffixMaxArr[i] = Math.max(sum, arr[i+1]);
        }
        int ans = Math.max(prefixMaxArr[length-1], suffixMaxArr[0]);
        for (int i = 1; i < length-1; i++) {
            int s = prefixMaxArr[i] + suffixMaxArr[i];
            if (arr[i] > 0) {
                s += arr[i];
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSum maximumSum = new MaximumSum();
        System.out.println(-1 == maximumSum.maximumSum(new int[]{-1,-1,-1,-1}));
        System.out.println(3 == maximumSum.maximumSum(new int[]{1,-2,-2,3}));
        System.out.println(4 == maximumSum.maximumSum(new int[]{1,-2,0,3}));
    }
}
