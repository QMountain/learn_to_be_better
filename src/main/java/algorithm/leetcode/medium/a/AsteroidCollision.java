package algorithm.leetcode.medium.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length-1; i++) {
            if (asteroids[i] > 0 && asteroids[i+1] < 0) {
                int abs1 = Math.abs(asteroids[i]);
                int abs2 = Math.abs(asteroids[i+1]);
                if (abs1 == abs2) {
                    i++;
                } else if (abs1 > abs2) {
                    list.add(asteroids[i]);
                    i++;
                }
            } else {
                list.add(asteroids[i]);
            }
        }
        if (asteroids[length-1] < 0 && asteroids[length-2] > 0 && Math.abs(asteroids[length-1]) <= Math.abs(asteroids[length-2])) {

        } else {
            list.add(asteroids[length-1]);
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        if (size < 2 || size == length) {
            return arr;
        }
        return asteroidCollision(arr);
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{-2,-2,-2,1})));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{-2,-1,1,2})));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{5, 10, -5})));
    }
}
