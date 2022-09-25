package algorithm.leetcode.easy.t;

public class TemperatureTrend {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int ans = 0;
        int count = 0;
        int length = temperatureA.length;
        for (int i = 0; i < length-1; i++) {
            if ((temperatureA[i] == temperatureA[i+1]
                    && temperatureB[i] == temperatureB[i+1])
            || (temperatureA[i] > temperatureA[i+1]
                    && temperatureB[i] > temperatureB[i+1])
            || (temperatureA[i] < temperatureA[i+1]
                    && temperatureB[i] < temperatureB[i+1])) {
                count++;
            } else {
                ans = Math.max(ans,count);
                count = 0;
            }
        }
        return Math.max(ans,count);
    }

    public static void main(String[] args) {
        TemperatureTrend temperatureTrend = new TemperatureTrend();
        System.out.println(temperatureTrend.temperatureTrend(new int[]{21,18,18,18,31}, new int[]{34,32,16,16,17}));
    }
}
