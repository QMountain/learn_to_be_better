package algorithm.leetcode.easy.m;

import java.util.LinkedList;

public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        LinkedList<Integer> writeIndexQueue = new LinkedList<>();
        for (int i = 0; i < length-1; i++) {
            if (charArray[i] == '0') {
                writeIndexQueue.addLast(i);
            } else {
                if (charArray[length - 1] != '1') {
                    charArray[i] = '0';
                    writeIndexQueue.addLast(i);
                    charArray[length - 1] = '1';
                } else {
                    if (!writeIndexQueue.isEmpty()) {
                        charArray[writeIndexQueue.pollFirst()] = '1';
                        charArray[i] = '0';
                        writeIndexQueue.addLast(i);
                    }
                }
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        MaximumOddBinaryNumber maximumOddBinaryNumber = new MaximumOddBinaryNumber();
        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber("110"));
        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber("11"));
        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber("0101"));
        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber("010"));
    }
}
