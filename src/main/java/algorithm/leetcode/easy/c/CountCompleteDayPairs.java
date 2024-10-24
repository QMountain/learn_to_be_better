package algorithm.leetcode.easy.c;

public class CountCompleteDayPairs {

    public int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        int[] arr = new int[24];
        for (int hour : hours) {
            arr[hour % 24]++;
        }
        if (arr[0] <= 2) {
            ans += arr[0] >> 1;
        } else {
            if (arr[0] % 2 == 0) {
                ans += (arr[0] >> 1) * (arr[0] - 1);
            } else {
                ans += ((arr[0] - 1) >> 1) * arr[0];
            }
        }
        if (arr[12] <= 2) {
            ans += arr[12] >> 1;
        } else {
            if (arr[12] % 2 == 0) {
                ans += (arr[12] >> 1) * (arr[12] - 1);
            } else {
                ans += ((arr[12] - 1) >> 1) * arr[12];
            }
        }
        for (int i = 1; i < 12; i++) {
            ans += arr[i] * arr[24 - i];
        }
        return ans;
    }

    public static void main(String[] args) {
        CountCompleteDayPairs countCompleteDayPairs = new CountCompleteDayPairs();
        System.out.println(2 == countCompleteDayPairs.countCompleteDayPairs(
                new int[]{12,12,30,24,24}));
    }
}
