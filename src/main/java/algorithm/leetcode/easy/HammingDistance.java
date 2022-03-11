package algorithm.leetcode.easy;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int res = 0;

        while (x > 1 || y > 1) {
            if (x % 2 != y % 2) {
                res++;
            }
            x = (x-x%2)/2;
            y = (y-y%2)/2;
        }
        if (x % 2 != y % 2) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(2 == hammingDistance.hammingDistance(1, 4));
        System.out.println(1 == hammingDistance.hammingDistance(3, 1));
    }
}
