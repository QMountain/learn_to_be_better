package algorithm.leetcode.medium.m;

public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        int length = s.length();
        int[][] count = new int[length][2];
        if (s.charAt(0) == '0') {
            count[0][0] = 1;
        } else {
            count[0][1] = 1;
        }
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                count[i][0] = count[i-1][0] + 1;
                count[i][1] = count[i-1][1];
            } else {
                count[i][0] = count[i-1][0];
                count[i][1] = count[i-1][1] + 1;
            }
        }
        int[][] countFromBack = new int[length][2];
        if (s.charAt(length-1) == '0') {
            countFromBack[length-1][0] = 1;
        } else {
            countFromBack[length-1][1] = 1;
        }
        for (int i = length-2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                countFromBack[i][0] = countFromBack[i+1][0] + 1;
                countFromBack[i][1] = countFromBack[i+1][1];
            } else {
                countFromBack[i][0] = countFromBack[i+1][0];
                countFromBack[i][1] = countFromBack[i+1][1] + 1;
            }
        }
        int min = length;
        min = Math.min(min,countFromBack[1][0]);
        min = Math.min(min,count[length-2][1]);
        for (int i = 1; i < length-1; i++) {
            int num = count[i-1][1] + countFromBack[i+1][0];
            min = Math.min(num,min);
        }
        return min;
    }

    public static void main(String[] args) {
        MinFlipsMonoIncr minFlipsMonoIncr = new MinFlipsMonoIncr();
        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("00011000"));
        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("10011111110010111011"));
        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("0101100011"));

        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("00110"));
    }
}
