package algorithm.leetcode.easy;

import java.util.Arrays;

public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        int[] arr = new int[2];
        int curRow = 1;
        int curRowUsedLength = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int width = widths[c - 97];
            if (100 - curRowUsedLength >= width) {
                curRowUsedLength += width;
            } else {
                curRow++;
                curRowUsedLength = width;
            }
        }
        arr[0] = curRow;
        arr[1] = curRowUsedLength;
        return arr;
    }

    public static void main(String[] args) {
        NumberOfLines numberOfLines = new NumberOfLines();
        System.out.println(Arrays.toString(numberOfLines.numberOfLines(
                new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "abcdefghijklmnopqrstuvwxyz")));
    }
}
