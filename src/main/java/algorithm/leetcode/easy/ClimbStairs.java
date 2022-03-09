package algorithm.leetcode.easy;

public class ClimbStairs {

    public int climbStairs(int n) {
        int res = 0;
        for (int i = 0; i <= n / 2; i++) {
            res += count(i,n-i*2);
        }
        return res;
    }

    // x个2，y个1
    public int count(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }
        if (x == 1 || y == 1) {
            return Math.max(x,y)+1;
        }

        return count(x-2,y)+count(x,y-2)+count(x-1,y-1)*2;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
       /* System.out.println(2 == climbStairs.climbStairs(2));
        System.out.println(3 == climbStairs.climbStairs(3));*/
        System.out.println(13 == climbStairs.climbStairs(6));
        System.out.println(3 == climbStairs.climbStairs(43));
    }
}
