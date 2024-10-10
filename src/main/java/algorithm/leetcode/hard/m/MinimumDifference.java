package algorithm.leetcode.hard.m;

import java.util.Arrays;

public class MinimumDifference {

    int length;
    String[] strArr;
    char[] binaryNum;
    int[] count;

    public int minimumDifference(int[] nums, int k) {
        length = nums.length;
        strArr = new String[length];
        binaryNum = new char[32];
        Arrays.fill(binaryNum, '0');
        count = new int[32];
        int ans = Integer.MAX_VALUE;
        int lastEnd = 0;
        // i 是起始
        for (int i = 0; i < length; i++) {
            if (nums[i] == k) {
                return 0;
            }
            ans = Math.min(ans, Math.abs(nums[i] - k));
            if (nums[i] > k) {
                continue;
            }
            // j 是结束
            for (int j = Math.max(lastEnd, i); j < length; j++) {
                if (j == i && strArr[j] != null) {
                    continue;
                }
                int n = addStr(nums[j], j);
                if (n == k) {
                    return 0;
                }
                if (n < k) {
                    ans = Math.min(ans, k - n);
                    if (j == length-1) {
                        return ans;
                    }
                } else {
                    ans = Math.min(ans, n - k);
                    // 先减去起始位置的
                    int a = minusStr(strArr[i]);
                    if (a == k) {
                        return 0;
                    }
                    while (a > k && j > i) {
                        a = minusStr(strArr[j--]);
                    }
                    ans = Math.min(ans, k - a);
                    lastEnd = j+1;
                    break;
                }
            }
        }
        return ans;
    }

    public int addStr(int num, int i) {
        String str = Integer.toBinaryString(num);
        strArr[i] = str;
        int bl = str.length();
        for (int l = 0; l < bl; l++) {
            if (str.charAt(l) == '0') {
                continue;
            }
            int index = 32 - (bl - l);
            count[index]++;
            binaryNum[index] = '1';
        }
        String s = new String(binaryNum);
        return Integer.parseInt(s, 2);
    }

    public int minusStr(String str) {
        int bsl = str.length();
        for (int l = 0; l < bsl; l++) {
            if (str.charAt(l) == '0') {
                continue;
            }
            int index = 32 - (bsl - l);
            if (--count[index] == 0) {
                binaryNum[index] = '0';
            }
        }
        String s = new String(binaryNum);
        return Integer.parseInt(s, 2);
    }

    public static void main(String[] args) {
        MinimumDifference minimumDifference = new MinimumDifference();
        System.out.println(23 == minimumDifference.minimumDifference(
                new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 3));
        System.out.println(23 == minimumDifference.minimumDifference(
                new int[]{57,40,10,48,72}, 97));
        System.out.println(4 == minimumDifference.minimumDifference(
                new int[]{23,75,88,50,18}, 79));
        System.out.println(8 == minimumDifference.minimumDifference(
                new int[]{8,21,100,78,52}, 60));
        System.out.println(1 == minimumDifference.minimumDifference(
                new int[]{2}, 3));
        System.out.println(9 == minimumDifference.minimumDifference(
                new int[]{1}, 10));
        System.out.println(1 == minimumDifference.minimumDifference(
                new int[]{1,3,1,3}, 2));
        System.out.println(0 == minimumDifference.minimumDifference(
                new int[]{1,2,4,5}, 3));
    }
}
