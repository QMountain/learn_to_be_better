package algorithm.leetcode.medium.r;

public class Rand10 {

    public int rand7() {
        return 1;
    }

    public int rand10() {
        int n1 = rand7();
        int n2 = rand7();
        int sum = n1 + n2;
        if (sum == 2 || sum == 4) {
            return 1;
        }
        if (sum == 5) {
            return 2;
        }
        if (sum == 7 && n1 <= 4) {
            return 3;
        }
        if (sum == 3 || sum == 7) {
            return 4;
        }
        if (sum == 8 && n1 <= 4) {
            return 5;
        }
        if (sum == 6 && n1 <= 4) {
            return 6;
        }
        if (sum == 6 || sum == 8) {
            return 7;
        }
        if (sum == 11) {
            return 8;
        }
        if (sum == 12 || sum == 14) {
            return 9;
        }
        if (sum == 10 && n1 <= 6) {
            return 10;
        }
        return rand10();
    }

}
