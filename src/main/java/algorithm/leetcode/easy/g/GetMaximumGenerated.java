package algorithm.leetcode.easy.g;

public class GetMaximumGenerated {

    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        if (n % 2 == 0) {
            return getMaximumGenerated(n-1);
        }
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        int max = 0;
        for (int i = 3; i <= n; i+=2) {
            max = Math.max(cal(i,arr),max);
        }
        return max;

    }

    public int cal(int n,int[] arr) {
        if (n <= 1) {
            return n;
        }
        while (n % 2 == 0) {
            n /= 2;
            if (arr[n] != 0) {
                return arr[n];
            }
        }
        int res = 0;
        if (arr[(n - 1) / 2] != 0) {
            res += arr[(n - 1) / 2];
        } else {
            int cal = cal((n - 1) / 2, arr);
            arr[(n - 1) / 2] = cal;
            res += cal;
        }
        if (arr[(n+1)/2] != 0) {
            res += arr[(n+1)/2];
        } else {
            int cal = cal((n + 1) / 2, arr);
            arr[(n + 1) / 2] = cal;
            res += cal((n+1)/2,arr);
        }
        arr[n] = res;
        return res;
    }

    public static void main(String[] args) {
        GetMaximumGenerated getMaximumGenerated = new GetMaximumGenerated();
        System.out.println(getMaximumGenerated.getMaximumGenerated(15));
    }
}
