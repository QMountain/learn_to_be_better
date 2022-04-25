package algorithm.leetcode.easy.i;

public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int remainder = num % 10;
        if (remainder == 0) {
            if (num % 100 != 0) {
                return false;
            }
            while (num % 100 == 0) {
                num /= 100;
            }
        }
        remainder = num % 10;
        if (remainder != 1 && remainder != 4 && remainder != 9
                && remainder != 6 && remainder != 5) {
            return false;
        }
        int bsc = num;
        int length = 1;
        while (bsc > 10) {
            bsc /= 10;
            length++;
        }
        int resMaxLength = (length+1)/2;

        int left = 1;
        for (int i = 0; i < resMaxLength-1; i++) {
            left *= 10;
        }
        left = left >= 10 ? left : 0;
        int right = left*10;
        if (remainder == 1) {
            left += 1;
            right += 1;
            boolean b = checkByZone(left, right, num);
            if (b) {
                return true;
            }
            left -= 1;
            right -= 1;
            left += 9;
            right += 9;
            return checkByZone(left,right,num);
        } else if (remainder == 4) {
            left += 2;
            right += 2;
            boolean b = checkByZone(left, right, num);
            if (b) {
                return true;
            }
            left -= 2;
            right -= 2;
            left += 8;
            right += 8;
            return checkByZone(left,right,num);
        } else if (remainder == 9) {
            left += 3;
            right += 3;
            boolean b = checkByZone(left, right, num);
            if (b) {
                return true;
            }
            left -= 3;
            right -= 3;
            left += 7;
            right += 7;
            return checkByZone(left,right,num);
        } else if (remainder == 6) {
            left += 4;
            right += 4;
            boolean b = checkByZone(left, right, num);
            if (b) {
                return true;
            }
            left -= 4;
            right -= 4;
            left += 6;
            right += 6;
            return checkByZone(left,right,num);
        } else {
            left += 5;
            right += 5;
            return checkByZone(left,right,num);
        }
    }

    public boolean checkByZone(int left, int right, int num) {
        while (left < right) {
            if (left + 1 == right) {
                return left * left == num || right * right == num;
            }
            int mid = (right-left)/2/10*10+left;
            if (mid == left) {
                if (num%left == 0 && num/left == left) {
                    return true;
                }
                return num%right == 0 && num/right == right;
            }
            if (num % mid == 0 && num/mid == mid) {
                return true;
            } else if (num/mid < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left*left == num;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        System.out.println(isPerfectSquare.isPerfectSquare(324));
        System.out.println(isPerfectSquare.isPerfectSquare(2401));
        System.out.println(isPerfectSquare.isPerfectSquare(808201));
        System.out.println(isPerfectSquare.isPerfectSquare(100));
        System.out.println(isPerfectSquare.isPerfectSquare(14));
        System.out.println(isPerfectSquare.isPerfectSquare(16));
    }
}
