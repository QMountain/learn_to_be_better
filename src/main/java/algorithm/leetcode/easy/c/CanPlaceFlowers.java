package algorithm.leetcode.easy.c;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i-1] == 0)
                    && (i == length-1 || flowerbed[i+1] == 0)) {
                max++;
                flowerbed[i] = 1;
            }
        }
        return max >= n;
    }

}
