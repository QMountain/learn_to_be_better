package algorithm.leetcode.medium.r;

public class RotatedDigits {

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    // 0,1,8 旋转后有效，没变
    // 2,5,6,9 旋转后有效，但变了
    // 3,4,7 旋转后无效
    public boolean isValid(int n) {
        boolean canChange = false;
        int gw;
        while (n > 0) {
            gw = n % 10;
            // 无效
            if (gw == 3 || gw == 4 || gw == 7) {
                return false;
            }
            if (gw == 2 || gw == 5 || gw == 6 || gw == 9) {
                canChange = true;
            }
            n /= 10;
        }
        return canChange;
    }

    public static void main(String[] args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        System.out.println(rotatedDigits.rotatedDigits(10));
    }
}
