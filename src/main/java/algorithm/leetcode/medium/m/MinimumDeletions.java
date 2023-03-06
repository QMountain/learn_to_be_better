package algorithm.leetcode.medium.m;

public class MinimumDeletions {

    // 第一遍 O(3n)
    public int minimumDeletions2(String s) {
        int length = s.length();
        int[] countBFromLeft = new int[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'b') {
                count++;
            }
            countBFromLeft[i] = count;
        }
        count = 0;
        int[] countAFromRight = new int[length];
        for (int i = length-1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                count++;
            }
            countAFromRight[i] = count;
        }
        int min = length;
        for (int i = 0; i < length; i++) {
            // left a + right b
            int curr = 0;
            if (i > 0) {
                curr += countBFromLeft[i-1];
            }
            if (i < length-1) {
                curr += countAFromRight[i+1];
            }
            min = Math.min(min, curr);
        }
        return min;
    }

    // 第二遍 O(2n)
    public int minimumDeletions(String s) {
        int length = s.length();
        int countA = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }
        if (countA == 0 || countA == length) {
            return 0;
        }
        int min = length;
        int currA = 0;
        for (int i = 0; i < length; i++) {
            int leftNeedRemove = i - currA;
            if (s.charAt(i) == 'a') {
                currA++;
            }
            int rightNeedRemove = countA-currA;
            min = Math.min(min, leftNeedRemove + rightNeedRemove);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumDeletions minimumDeletions = new MinimumDeletions();
        System.out.println(0 == minimumDeletions.minimumDeletions("b"));
        System.out.println(2 == minimumDeletions.minimumDeletions("bbaaaaabb"));
        System.out.println(2 == minimumDeletions.minimumDeletions("aababbab"));
    }
}
