package algorithm.leetcode.easy.d;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        int length = candyType.length;
        Set<Integer> set = new HashSet<>(length);
        for (int i = 0; i < length && set.size() < length/2; i++) {
            set.add(candyType[i]);
        }
        return set.size();
    }

    // 分糖果 II
    public int[] distributeCandies(int candies, int num_people) {
        double v = (Math.sqrt(candies * 2 + 0.25) - 0.5) / num_people;
        int rows = (int)v;
        int cost = (rows*num_people*rows*num_people+rows*num_people)/2;
        int left = candies-cost;
        int start = rows*num_people+1;
        int endIndex = 0;
        for (int i = 0; i < num_people; i++) {
            if (left-i <= start) {
                endIndex = i;
                break;
            } else {
                left -= start+i;
            }
        }
        int base = (rows*(rows-1)*num_people+rows*2)/2;
        int[] arr = new int[num_people];
        for (int i = 0; i < num_people; i++) {
            arr[i] += base + i*rows;
            if (i < endIndex) {
                arr[i] += start + i;
            } else if (i == endIndex) {
                arr[i] += left;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        System.out.println(Arrays.toString(
                distributeCandies.distributeCandies(10, 3)));
        System.out.println(Arrays.toString(distributeCandies.distributeCandies(7, 4)));
    }
}
