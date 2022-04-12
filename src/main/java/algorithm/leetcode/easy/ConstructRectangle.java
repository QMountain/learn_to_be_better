package algorithm.leetcode.easy;

import java.util.Arrays;

public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int[] arr = new int[2];
        int sqrt = (int)Math.sqrt(area);
        if (sqrt*sqrt == area) {
            arr[0] = sqrt;
            arr[1] = sqrt;
            return arr;
        }
        int w = sqrt;
        while (area % w != 0) {
            w--;
        }
        arr[0] = area/w;
        arr[1] = w;
        return arr;
    }

    public static void main(String[] args) {
        ConstructRectangle constructRectangle = new ConstructRectangle();
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(122122)));
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(37)));
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(4)));
    }
}
