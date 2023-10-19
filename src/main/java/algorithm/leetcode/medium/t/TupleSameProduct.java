package algorithm.leetcode.medium.t;

import java.util.*;

public class TupleSameProduct {

    public int tupleSameProduct(int[] nums) {
        int length = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length-1; i++) {
            int num1 = nums[i];
            for (int j = i+1; j < length; j++) {
                int num2 = nums[j];
                int key = num1 * num2;
                Integer oldPairs = map.getOrDefault(key, 0);
                if (oldPairs > 0) {
                    ans += 8 * oldPairs;
                }
                map.put(key, oldPairs+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TupleSameProduct tupleSameProduct = new TupleSameProduct();
        System.out.println(40 == tupleSameProduct.tupleSameProduct(new int[]{2,3,4,6,8,12}));
        System.out.println(16 == tupleSameProduct.tupleSameProduct(new int[]{1,2,4,5,10}));
        System.out.println(8 == tupleSameProduct.tupleSameProduct(new int[]{2,3,4,6}));
    }
}
