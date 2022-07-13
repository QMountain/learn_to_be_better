package algorithm.leetcode.easy.t;

public class TotalMoney {

    public int totalMoney(int n) {
        int weeks = n / 7;
        int sumWeek = (28 + (weeks - 1) * 7 + 28) * weeks / 2;
        int lastWeekStart = weeks+ 1;
        int leftDays = n- weeks*7;
        int leftSum = (lastWeekStart + lastWeekStart + leftDays-1) * leftDays / 2;
        sumWeek += leftSum;
        return sumWeek;
    }

    public static void main(String[] args) {
        TotalMoney totalMoney = new TotalMoney();
        System.out.println(totalMoney.totalMoney(4));
        System.out.println(totalMoney.totalMoney(10));
        System.out.println(totalMoney.totalMoney(20));
    }
}
