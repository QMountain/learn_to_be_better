package algorithm.leetcode.medium.h;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        if (length == 1) {
            return citations[0] == 0 ? 0 : 1;
        }
        if (citations[0] >= length) {
            return length;
        }
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length-i) {
                return length-i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(2 == hIndex.hIndex(new int[]{2,3,2}));
        System.out.println(1 == hIndex.hIndex(new int[]{0,1,1}));
        System.out.println(2 == hIndex.hIndex(new int[]{2,2,2}));
        System.out.println(1 == hIndex.hIndex(new int[]{1,1}));
        System.out.println(0 == hIndex.hIndex(new int[]{0,0}));
        System.out.println(2 == hIndex.hIndex(new int[]{11,15}));
        System.out.println(hIndex.hIndex(new int[]{0}));
        System.out.println(hIndex.hIndex(new int[]{1,3,1}));
        System.out.println(hIndex.hIndex(new int[]{3,0,6,1,5}));
    }
}
