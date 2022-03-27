package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        double pow = Math.pow(2, n);
        int length = (int)pow;
        String allOne = Integer.toBinaryString(length - 1);
        int strLength = allOne.length();
        int[][] binaryArr = new int[length][strLength];

        int opColIndex = 0;
        while (opColIndex < strLength) {
            int cycle = length;
            for (int i = 0; i < opColIndex; i++) {
                cycle /= 2;
            }
            int startIndex = cycle/2;
            while (startIndex < length) {
                for (int i = startIndex; i < startIndex + cycle && i < length; i++) {
                    binaryArr[i][opColIndex] = 1;
                }
                startIndex += cycle*2;
            }
            opColIndex++;
        }
        List<Integer> list = new ArrayList<>(length);
        for (int[] ints : binaryArr) {
            StringBuilder sb = new StringBuilder();
            for (int i : ints) {
                sb.append(i);
            }
            Integer value = Integer.valueOf(sb.toString(), 2);
            list.add(value);
        }
        return list;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(4));
        System.out.println(grayCode.grayCode(2));
        System.out.println(grayCode.grayCode(1));
        System.out.println(grayCode.grayCode(3));

    }
}
