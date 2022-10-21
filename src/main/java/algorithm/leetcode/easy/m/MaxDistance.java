package algorithm.leetcode.easy.m;

public class MaxDistance {

    public int maxDistance(int[] colors) {
        int length = colors.length;
        int distance = length -1;
        while (distance > 1) {
            for (int i = 0; i < length - distance; i++) {
                if (colors[i] != colors[i+distance]) {
                    return distance;
                }
            }
            distance--;
        }
        return 1;
    }

}
