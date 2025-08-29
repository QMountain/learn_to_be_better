package algorithm.leetcode.medium.f;

public class FlowerGame {

    public long flowerGame(int n, int m) {
        return (n >> 1L) * ((m + 1L) >> 1L) + ((n + 1L) >> 1L) * (m >> 1L);
    }

}
