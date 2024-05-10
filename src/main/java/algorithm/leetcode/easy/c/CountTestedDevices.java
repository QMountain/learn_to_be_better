package algorithm.leetcode.easy.c;

public class CountTestedDevices {

    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage - ans > 0) {
                ans++;
            }
        }
        return ans;
    }

}
