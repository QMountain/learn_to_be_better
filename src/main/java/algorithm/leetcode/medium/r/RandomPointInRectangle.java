package algorithm.leetcode.medium.r;

import java.util.Arrays;
import java.util.Random;

public class RandomPointInRectangle {

    Random random;
    int[] pointCountPrefix;
    int[][] rects;

    public RandomPointInRectangle(int[][] rects) {
        int length = rects.length;
        int[] pointCount = new int[length];
        for (int i = 0; i < length; i++) {
            int[] rect = rects[i];
            int startRow = rect[0];
            int startCol = rect[1];
            int endRow = rect[2];
            int endCol = rect[3];
            int count = (endRow-startRow+1)*(endCol-startCol+1);
            pointCount[i] = count;
        }
        int[] pointCountPrefix = new int[length];
        pointCountPrefix[0] = pointCount[0];
        for (int i = 1; i < length; i++) {
            pointCountPrefix[i] = pointCountPrefix[i-1]+pointCount[i];
        }
        this.pointCountPrefix = pointCountPrefix;
        this.rects = rects;
        this.random = new Random();
    }

    public int[] pick() {
        int num = random.nextInt(pointCountPrefix[rects.length-1]);
        int index = binarySearch(pointCountPrefix,num+1);
        int[] rect = rects[index];
        if (index > 0) {
            index--;
            num -= pointCountPrefix[index];
        }
        int startRow = rect[0];
        int startCol = rect[1];
        int endCol = rect[3];
        int rowLength = endCol-startCol+1;
        int x = startRow + num/rowLength;
        int y = startCol + num%rowLength;
        int[] point = new int[2];
        point[0] = x;
        point[1] = y;
        return point;
    }

    public int binarySearch(int[] pointCountPrefix,int target) {
        int low = 0;
        int high = pointCountPrefix.length-1;
        while (low < high) {
            int mid = (low+high)/2;
            int num = pointCountPrefix[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        RandomPointInRectangle randomPointInRectangle = new RandomPointInRectangle(
                new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}});
        System.out.println(Arrays.toString(randomPointInRectangle.pick()));
        System.out.println(Arrays.toString(randomPointInRectangle.pick()));
        System.out.println(Arrays.toString(randomPointInRectangle.pick()));
    }
}
