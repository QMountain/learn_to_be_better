package algorithm.leetcode.medium.s;

public class SmallestRepunitDivByK {

    public int smallestRepunitDivByK(int k) {
        if (k == 1) {
            return 1;
        }
        int gw = k % 10;
        if (gw != 1 && gw != 3 && gw != 7 && gw != 9) {
            return -1;
        }
        int count = 1;
        int remainder = 1;
        while (remainder != 0) {
            count++;
            remainder = ((remainder * 10) % k + 1) % k;
        }
        return count;
    }

    public static void main(String[] args) {
        SmallestRepunitDivByK smallestRepunitDivByK = new SmallestRepunitDivByK();
        System.out.println(81 == smallestRepunitDivByK.smallestRepunitDivByK(81));
        System.out.println(22 == smallestRepunitDivByK.smallestRepunitDivByK(23));
        System.out.println(16 == smallestRepunitDivByK.smallestRepunitDivByK(17));
        System.out.println(1 == smallestRepunitDivByK.smallestRepunitDivByK(1));
        System.out.println(-1 == smallestRepunitDivByK.smallestRepunitDivByK(2));
        System.out.println(3 == smallestRepunitDivByK.smallestRepunitDivByK(3));
    }
}
