package algorithm.leetcode.easy.d;

import java.util.Arrays;

public class Decode {

    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int[] arr = new int[length+1];
        arr[0] = first;
        for (int i = 0; i < length; i++) {
            arr[i+1] = encoded[i] ^ arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        Decode decode = new Decode();
        System.out.println(Arrays.toString(decode.decode(new int[]{6, 2, 7, 3}, 4)));
        System.out.println(Arrays.toString(decode.decode(new int[]{1, 2, 3}, 1)));
    }
}
