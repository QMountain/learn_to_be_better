package algorithm.leetcode.easy.b;

import java.util.Arrays;

public class BreakfastNumber {

    int[] drinks;

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        this.drinks = drinks;
        int ans = 0;
        int cs = 1000000007;
        int right = drinks.length-1;
        for (int j : staple) {
            if (j >= x) {
                break;
            }
            int search = -1;
            if (x-j >= drinks[0]) {
                search = binarySearch(0, right, x - j);
            }
            if (search == -1) {
                break;
            }
            ans += search + 1;
            ans %= cs;
            right = search;
        }
        return ans;
    }

    public int binarySearch(int left, int right, int target) {
        while (left < right) {
            int mid = (left+right)/2;
            if (drinks[mid] > target) {
                right = mid;
            } else {
                if (left == mid) {
                    if (drinks[right] <= target) {
                        return right;
                    }
                    return left;
                } else {
                    left = mid;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BreakfastNumber breakfastNumber = new BreakfastNumber();
        System.out.println(breakfastNumber.breakfastNumber(new int[]{7,3,4,3,9,9,10,8,8,3}, new int[]{7,10,6,7,5,2,8,4,5,8}, 5));
        System.out.println(breakfastNumber.breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
        System.out.println(breakfastNumber.breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
    }
}
