package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructArray {

    public int[] constructArray(int n, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int left = 2;
        int right = n;
        while (k > 1) {
            if (k-1 > 1) {
                list.add(right--);
                list.add(left++);
                k -= 2;
            } else {
                list.add(left+1);
                list.add(left);
                left += 2;
                break;
            }
        }
        for (int i = left; i <= right; i++) {
            list.add(i);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        ConstructArray constructArray = new ConstructArray();
        System.out.println(Arrays.toString(constructArray.constructArray(5, 4)));
        System.out.println(Arrays.toString(constructArray.constructArray(3, 2)));
        System.out.println(Arrays.toString(constructArray.constructArray(3, 1)));
    }

}
