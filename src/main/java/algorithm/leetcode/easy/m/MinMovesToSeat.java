package algorithm.leetcode.easy.m;

import java.util.Arrays;

public class MinMovesToSeat {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int length = seats.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            res += Math.abs(seats[i]-students[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MinMovesToSeat minMovesToSeat = new MinMovesToSeat();
        System.out.println(7 == minMovesToSeat.minMovesToSeat(
                new int[]{4,1,5,9}, new int[]{1,3,2,6}));
        System.out.println(4 == minMovesToSeat.minMovesToSeat(new int[]{3,1,5}, new int[]{2,7,4}));
    }

}
