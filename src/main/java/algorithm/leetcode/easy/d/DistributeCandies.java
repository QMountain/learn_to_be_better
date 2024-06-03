package algorithm.leetcode.easy.d;

import java.util.*;

public class DistributeCandies {

    // 题号 2928 给小朋友们分糖果 I
    // 1 <= n <= 50
    // 1 <= limit <= 50
    public int distributeCandies(int n, int limit) {
        if (n > limit * 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i + j > n) {
                    break;
                }
                if (n - i - j <= limit) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int distributeCandies(int[] candyType) {
        int length = candyType.length;
        Set<Integer> set = new HashSet<>(length);
        for (int i = 0; i < length && set.size() < length/2; i++) {
            set.add(candyType[i]);
        }
        return set.size();
    }

    // 题号 1103 分糖果 II
    public int[] distributeCandies2(int candies, int num_people) {
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
        System.out.println(distributeCandies.distributeCandies(3, 3));
        System.out.println(Arrays.toString(
                distributeCandies.distributeCandies2(10, 3)));
        System.out.println(Arrays.toString(distributeCandies
                .distributeCandies2(7, 4)));
    }
}
