package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsInsideSquare {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int length = points.length;
        int[][] arr = new int[length][2];
        int[] count = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int[] point = new int[2];
            point[0] = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            char c = s.charAt(i);
            point[1] = c - 'a';
            if (count[point[1]] + 1 > 1) {
                map.put(c, ++count[point[1]]);
            } else {
                count[point[1]]++;
            }
            arr[i] = point;
        }
        if (map.isEmpty()) {
            return length;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int lastRemove = arr[length-1][0] + 1;
        for (int i = length-1; i >= 0; i--) {
            if (arr[i][0] < lastRemove) {
                if (map.isEmpty()) {
                    return i + 1;
                }
            }
            char key = (char) (arr[i][1] + 'a');
            Integer num = map.getOrDefault(key, 0);
            if (num > 2) {
                map.put(key, num - 1);
            } else if (num == 2) {
                map.remove(key);
            }
            lastRemove = arr[i][0];
        }
        return 0;
    }

    public static void main(String[] args) {
        MaxPointsInsideSquare maxPointsInsideSquare = new MaxPointsInsideSquare();
        System.out.println(1 == maxPointsInsideSquare.maxPointsInsideSquare(
                new int[][]{{1,1},{-2,-2},{-2,2}}, "abb"));
        System.out.println(2 == maxPointsInsideSquare.maxPointsInsideSquare(
                new int[][]{{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}}, "abdca"));
    }
}
