package algorithm.leetcode.medium.m;

public class MaximumSum {

    // 1 <= arr.length <= 10^5
    // -10^4 <= arr[i] <= 10^4
    public int maximumSum(int[] arr) {
        int length = arr.length;
        int min = arr[0];
        int max = arr[0];
        // 从0累加最小和
        int historyMinSum = arr[0];
        int totalSum = arr[0];
        // 从一个点往前累计最大和，不包括当前点
        int[] prefixMaxSum = new int[length];
        for (int i = 1; i < length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (historyMinSum < 0) {
                prefixMaxSum[i] = totalSum - historyMinSum;
            } else {
                prefixMaxSum[i] = totalSum;
            }
            totalSum += arr[i];
            historyMinSum = Math.min(historyMinSum, totalSum);
        }
        if (max <= 0) {
            return max;
        }
        if (min >= 0) {
            return totalSum;
        }
        int ans = arr[length-1];
        historyMinSum = arr[length-1];
        totalSum = arr[length-1];
        for (int i = length-2; i >= 0; i--) {
            ans = Math.max(ans, arr[i]);
            int right = 0;
            if (historyMinSum >= 0) {
                right = totalSum;
            } else {
                right = Math.max(right, totalSum - historyMinSum);
            }
            int v = Math.max(0, prefixMaxSum[i]);
            if (arr[i] > 0) {
                v += arr[i];
            }
            v += right;
            ans = Math.max(ans, v);
            totalSum += arr[i];
            historyMinSum = Math.min(historyMinSum, totalSum);
        }
        return ans;
    }

    // 执行结果，dp可以只遍历一次，有待优化
    public int maximumSum2(int[] arr) {
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
        System.out.println(7 == maximumSum.maximumSum(new int[]{1,-4,-5,-2,5,0,-1,2}));
        System.out.println(-1 == maximumSum.maximumSum(new int[]{-1,-1,-1,-1}));
        System.out.println(3 == maximumSum.maximumSum(new int[]{1,-2,-2,3}));
        System.out.println(4 == maximumSum.maximumSum(new int[]{1,-2,0,3}));
    }
}
