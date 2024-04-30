package algorithm.leetcode.easy.n;

public class NumberOfEmployeesWhoMetTarget {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour >= target) {
                ans++;
            }
        }
        return ans;
    }

}
