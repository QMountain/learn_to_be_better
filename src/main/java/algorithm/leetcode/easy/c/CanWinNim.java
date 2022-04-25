package algorithm.leetcode.easy.c;

public class CanWinNim {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    // true i win  false other win
    public boolean prefer(int n, boolean preferRes) {
        if (n <= 3) {
            return preferRes;
        }
        if (prefer(n-1,!preferRes) == preferRes) {
            return preferRes;
        }
        if (prefer(n-2,!preferRes) == preferRes) {
            return preferRes;
        }
        if (prefer(n-3,!preferRes) == preferRes) {
            return preferRes;
        }
        return !preferRes;
    }

    public static void main(String[] args) {
        CanWinNim canWinNim = new CanWinNim();
        System.out.println(canWinNim.canWinNim(43));
        System.out.println(!canWinNim.canWinNim(4));
        System.out.println(canWinNim.canWinNim(1));
        System.out.println(canWinNim.canWinNim(2));
    }
}
