package algorithm.leetcode.medium.m;

public class MinimumOperations {

    public int minimumOperations(String num) {
        int length = num.length();
        // 以 00 25 50 75 结尾
        int firstZeroIndex = -1;
        int firstFiveIndex = -1;
        char[] charArray = num.toCharArray();
        for (int i = length-1; i >= 0; i--) {
            if (charArray[i] == '0') {
                if (firstZeroIndex == -1) {
                    // 记录第一次出现的 0
                    firstZeroIndex = i;
                } else {
                    // 00 结尾
                    return length - i - 2;
                }
            } else if (charArray[i] == '2') {
                if (firstFiveIndex != -1) {
                    // 第一次 25 结尾
                    return length - i - 2;
                }
            } else if (charArray[i] == '5') {
                if (firstFiveIndex == -1) {
                    // 记录第一次出现的 5
                    firstFiveIndex = i;
                    if (firstZeroIndex != -1) {
                        // 第一次出现的 50 结尾
                        return length - i - 2;
                    }
                }
            } else if (charArray[i] == '7' && firstFiveIndex != -1) {
                return length - i - 2;
            }
        }
        return firstZeroIndex == -1 ? length : length - 1;
    }

    public static void main(String[] args) {
        MinimumOperations minimumOperations = new MinimumOperations();
        System.out.println(1 == minimumOperations.minimumOperations("10"));
        System.out.println(3 == minimumOperations.minimumOperations("2908305"));
        System.out.println(2 == minimumOperations.minimumOperations("2245047"));
    }
}
