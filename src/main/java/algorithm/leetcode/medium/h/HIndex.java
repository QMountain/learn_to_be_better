package algorithm.leetcode.medium.h;

import java.util.Arrays;

public class HIndex {

    // 题号 274. H指数
    public int hIndex3(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int paperCount;
        for (int i = 0; i < length; i++) {
            paperCount = length - i;
            if (citations[i] >= paperCount) {
                return paperCount;
            }
        }
        return 0;
    }

    // 题号 275 H指数II
    public int hIndexII(int[] citations) {
        int length = citations.length;
        if (length == 1) {
            return citations[0] == 0 ? 0 : 1;
        }
        int left = 0;
        int right = citations.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            int count = length - mid;
            if (citations[mid] >= count) {
                right = mid;
            } else {
                if (left == mid) {
                    left++;
                } else {
                    left = mid;
                }
            }
        }
        return citations[left] >= length-left ? length-left : 0;
    }

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
        System.out.println(3 == hIndex.hIndex3(new int[]{3,0,6,1,5}));
        System.out.println(1 == hIndex.hIndex3(new int[]{1,3,1}));

        System.out.println(0 == hIndex.hIndexII(new int[]{0, 0}));
        System.out.println(2 == hIndex.hIndexII(new int[]{1, 2, 100}));
        System.out.println(3 == hIndex.hIndexII(new int[]{0, 1, 3, 5, 6}));

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
