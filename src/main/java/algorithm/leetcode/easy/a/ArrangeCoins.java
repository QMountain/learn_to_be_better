package algorithm.leetcode.easy.a;

public class ArrangeCoins {

    public int arrangeCoins(int n) {
        if (n > 2147450880) {
            return 65535;
        }
        int res = (int)(Math.sqrt(n)*Math.sqrt(2));
        int max;
        int min;
        if (res % 2 == 0) {
            max = res/2*(res+1);
            min = res/2*(res-1);
        } else {
            max = (res+1)/2*res;
            min = (res-1)/2*res;
        }
        if (max == n) {
            return res;
        }
        if (max > n && min <= n) {
            return res-1;
        } else if (max < n) {
            while (true) {
                res++;
                int sum;
                if (res % 2 == 0) {
                    sum = res/2*(res+1);
                } else {
                    sum = (res+1)/2*res;
                }
                if (sum == n) {
                    return res;
                } else if (sum > n) {
                    return res-1;
                }
            }
        } else {
            while (true) {
                res--;
                int sum;
                if (res % 2 == 0) {
                    sum = res/2*(res-1);
                } else {
                    sum = (res-1)/2*res;
                }
                if (sum == n) {
                    return res;
                } else if (sum < n) {
                    return res-1;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        System.out.println(arrangeCoins.arrangeCoins(2147483647));
        System.out.println(arrangeCoins.arrangeCoins(1681692777));
        System.out.println(arrangeCoins.arrangeCoins(1804289383));
        System.out.println(arrangeCoins.arrangeCoins(4));
        System.out.println(arrangeCoins.arrangeCoins(8));
        System.out.println(arrangeCoins.arrangeCoins(5));
        System.out.println(arrangeCoins.arrangeCoins(3));
    }
}
