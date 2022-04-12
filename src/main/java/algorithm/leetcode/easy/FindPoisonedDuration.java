package algorithm.leetcode.easy;

public class FindPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = duration;
        int length = timeSeries.length;
        for (int i = 0; i < length - 1; i++) {
            if (timeSeries[i] + duration <= timeSeries[i+1]) {
                total += duration;
            } else {
                total += timeSeries[i+1] - timeSeries[i];
            }
        }
        return total;
    }

}
