package algorithm.leetcode.medium.m;

public class MinSpeedOnTime {

    public int minSpeedOnTime(int[] dist, double hour) {
        int length = dist.length;
        if (length - 1 >= hour) {
            return -1;
        }
        int totalDist = 0;
        int maxDist = dist[0];
        for (int i : dist) {
            totalDist += i;
            maxDist = Math.max(maxDist, i);
        }
        int minSpeed = (int) (totalDist / hour);
        if (totalDist % hour != 0 && length > 1) {
            minSpeed++;
        }
        int eachDistMaxTime = (int) (hour / length);
        if (length > hour && hour % length != 0) {
            eachDistMaxTime++;
        }
        int maxSpeed = (maxDist + eachDistMaxTime) / eachDistMaxTime;
        if (length > hour) {
            double t = hour + 1 - length;
            double v = dist[length - 1] / t;
            maxSpeed = (int) Math.max(maxSpeed, (v + 1));
        }
        while (minSpeed < maxSpeed) {
            int speed = (minSpeed + maxSpeed) >> 1;
            int time = 0;
            for (int i = 0; i < length -1; i++) {
                time += dist[i] / speed;
                if (dist[i] % speed != 0) {
                    time++;
                }
            }
            double lastTime = (double) dist[length - 1] / speed;
            if (time < hour - lastTime) {
                maxSpeed = speed;
            } else if (time + lastTime == hour) {
                return speed;
            } else {
                if (minSpeed == speed) {
                    return maxSpeed;
                }
                minSpeed = speed;
            }
        }
        return minSpeed;
    }

    public static void main(String[] args) {
        MinSpeedOnTime minSpeedOnTime = new MinSpeedOnTime();
        System.out.println(15 == minSpeedOnTime.minSpeedOnTime(
                new int[]{69}, 4.6));
        System.out.println(78 == minSpeedOnTime.minSpeedOnTime(
                new int[]{92,41,28,84,64,51,83,59,19,34,18,32,96,72,69,34,96,75,55,75,52,47,29,18,66,64,12,97,7,15,20,81,21,88,55,77,9,50,49,77,60,68,33,71,2,88,93,15,88,69,97,35,99,83,44,15,38,56,21,59,1,93,93,34,65,98,23,65,14,81,39,82,65,78,26,20,48,98,21,70,100,68,1,77,42,63}, 107.52));
        System.out.println(10000000 == minSpeedOnTime.minSpeedOnTime(
                new int[]{1,1,100000}, 2.01));
        System.out.println(-1 == minSpeedOnTime.minSpeedOnTime(
                new int[]{1,3,2}, 1.9));
        System.out.println(3 == minSpeedOnTime.minSpeedOnTime(
                new int[]{1,3,2}, 2.7));
        System.out.println(1 == minSpeedOnTime.minSpeedOnTime(
                new int[]{1,3,2}, 6));
    }
}
