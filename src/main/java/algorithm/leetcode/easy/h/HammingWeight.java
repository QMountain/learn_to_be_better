package algorithm.leetcode.easy.h;

public class HammingWeight {

    // jdk
    public int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    public int hammingWeight2(int n) {
        int weight = 0;
        while (n > 0) {
            weight++;
            n = n & (n-1);
        }
        return weight;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(12));
        System.out.println(hammingWeight.hammingWeight(3));
    }
}
