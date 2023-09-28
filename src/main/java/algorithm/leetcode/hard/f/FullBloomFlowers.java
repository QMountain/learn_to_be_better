package algorithm.leetcode.hard.f;

import java.util.*;

public class FullBloomFlowers {

    static class Segment {
        int start;
        int end;
        int count;
        public Segment(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        LinkedList<Segment> list = new LinkedList<>();
        list.add(new Segment(flowers[0][0], flowers[0][1], 1));
        int length = flowers.length;
        for (int i = 1; i < length; i++) {

        }

    }

    public static void main(String[] args) {
        FullBloomFlowers fullBloomFlowers = new FullBloomFlowers();
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{29,46},{8,32},{16,36},{49,49},{42,43}}, new int[]{31})));
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{19,37},{19,38},{19,35}}, new int[]{6,7,21,1,13,37,5,37,46,43})));
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{1, 10}, {3, 3}}, new int[]{3, 3, 2})));
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11})));
    }
}
