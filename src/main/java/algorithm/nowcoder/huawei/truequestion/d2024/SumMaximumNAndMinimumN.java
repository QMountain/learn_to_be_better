package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 最大N个数与最小N个数的和
public class SumMaximumNAndMinimumN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(getResult(arr, n));
    }

    public static int getResult(int[] arr, int n) {
        if (n <= 0) return -1;

        HashSet<Integer> set = new HashSet<>();

        for (int val : arr) {
            if (val < 0 || val > 1000) return -1;
            set.add(val);
        }

        if (set.size() < n * 2) return -1;

        Integer[] distinct_arr = set.toArray(new Integer[0]);

        Arrays.sort(distinct_arr, (a, b) -> a - b);

        int l = 0;
        int r = distinct_arr.length - 1;
        int ans = 0;

        while (n > 0) {
            ans += distinct_arr[l] + distinct_arr[r];
            l++;
            r--;
            n--;
        }

        return ans;
    }
}
