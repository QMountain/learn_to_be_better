package algorithm.leetcode.easy.i;

public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        /*if (n <= 0) {
            return false;
        }
        String string = Integer.toBinaryString(n);
        String s = string.replaceFirst("1", "0");
        return !s.contains("1");*/
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(-16));
        System.out.println(isPowerOfTwo.isPowerOfTwo(1));
        System.out.println(isPowerOfTwo.isPowerOfTwo(16));
        System.out.println(isPowerOfTwo.isPowerOfTwo(3));
    }
}
