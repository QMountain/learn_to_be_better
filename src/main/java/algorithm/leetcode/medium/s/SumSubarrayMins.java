package algorithm.leetcode.medium.s;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SumSubarrayMins {

    // 题号 907 子数组的最小值之和
    // 官解 dp
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        final int MOD = 1000000007;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[monoStack.peek()] > arr[i]) {
                monoStack.pop();
            }
            int k = monoStack.isEmpty() ? (i + 1) : (i - monoStack.peek());
            dp[i] = k * arr[i] + (monoStack.isEmpty() ? 0 : dp[i - k]);
            ans = (ans + dp[i]) % MOD;
            monoStack.push(i);
        }
        return (int) ans;
    }

    // 题号 907 子数组的最小值之和
    // 官解 单调栈
    public int sumSubarrayMins3(int[] arr) {
        int n = arr.length;
        // 单调栈每次都只找一侧，两次遍历
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]) {
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]) {
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }

    public int sumSubarrayMins2(int[] arr) {
        int length = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int cs = 1000_000_007;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int leftMin = 0;
            if (map.containsKey(arr[i])) {
                Integer v = map.get(arr[i]);
                leftMin = v + 1;
            }
            map.put(arr[i],i);
            int startCount = 1;
            for (int j = i-1; j >= leftMin; j--) {
                if (arr[j] >= arr[i]) {
                    startCount++;
                } else {
                    break;
                }
            }
            int endCount = 1;
            for (int j = i+1; j < length; j++) {
                if (arr[j] >= arr[i]) {
                    endCount++;
                } else {
                    break;
                }
            }
            long curr = ((long) startCount *endCount%cs)*arr[i] % cs;
            ans += curr;
            ans %= cs;
        }
        return ans;
    }

    public static void main(String[] args) {
        SumSubarrayMins sumSubarrayMins = new SumSubarrayMins();
        System.out.println(593 == sumSubarrayMins.sumSubarrayMins(new int[]{71,55,82,55}));
        System.out.println(17 == sumSubarrayMins.sumSubarrayMins(new int[]{3,1,2,4}));
        System.out.println(444 == sumSubarrayMins.sumSubarrayMins(new int[]{11,81,94,43,3}));
    }

}
