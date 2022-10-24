package algorithm.leetcode.medium.f;

public class FindNthDigit {

    public int findNthDigit(int n) {
        int baseNum = 1;
        int base = 9;
        int length = 1;
        while (n > base*length) {
            n -= base * length;
            baseNum *= 10;
            base *= 10;
            length++;
            if (Integer.MAX_VALUE / base < length) {
                break;
            }
        }
        int addTimes = (n-1) / length;
        int num = baseNum+addTimes;
        char c = String.valueOf(num).charAt((n-1) % length);
        return Integer.parseInt(c + "");
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(1 == findNthDigit.findNthDigit(1000000000));
        System.out.println(3 == findNthDigit.findNthDigit(3));
        System.out.println(0 == findNthDigit.findNthDigit(11));
    }
}
