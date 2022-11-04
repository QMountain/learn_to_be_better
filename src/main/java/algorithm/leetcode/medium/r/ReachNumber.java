package algorithm.leetcode.medium.r;

public class ReachNumber {

    public int reachNumber(int target) {
        int abs = Math.abs(target);
        int n = (int)((Math.sqrt(abs*8+1)-1)/2);
        if (n * (n + 1)/2 == abs) {
            return n;
        }
        while (true) {
            n++;
            int sum = n*(n+1)/2;
            if (sum-2 < abs) {
                continue;
            }
            if ((sum - abs) % 2 == 0) {
                return n;
            }
        }
    }

    public static void main(String[] args) {
        ReachNumber reachNumber = new ReachNumber();
        System.out.println(5 == reachNumber.reachNumber(5));
        System.out.println(3 == reachNumber.reachNumber(4));
        System.out.println(3 == reachNumber.reachNumber(-2));
        System.out.println(3 == reachNumber.reachNumber(2));
        System.out.println(2 == reachNumber.reachNumber(3));
    }
}
