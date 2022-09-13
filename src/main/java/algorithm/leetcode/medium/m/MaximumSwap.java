package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaximumSwap {

    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int length = s.length();
        int[] arr = new int[10];
        Arrays.fill(arr,-1);
        int count = 10;
        for (int i = length-1; i >= 0; i--) {
            int index = s.charAt(i) - '0';
            if (arr[index] == -1) {
                arr[index] = i;
            }
            if (--count == 0) {
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            int curr = s.charAt(i) - '0';
            for (int j = 9; j > curr; j--) {
                if (arr[j] != -1 && arr[j] > i) {
                    char[] chars = s.toCharArray();
                    char c = chars[i];
                    chars[i] = chars[arr[j]];
                    chars[arr[j]] = c;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(9973));
        System.out.println(maximumSwap.maximumSwap(2736));
    }
}
