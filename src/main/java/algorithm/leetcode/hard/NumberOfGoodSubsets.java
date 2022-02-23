package algorithm.leetcode.hard;

import java.util.HashMap;

/**
 * @ClassName NumberOfGoodSubsets
 * @Description
 * @Author qsf
 * Date   2022-02-22  15:46
 */
public class NumberOfGoodSubsets {

    public int numberOfGoodSubsets(int[] nums) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (num != 2 && num % 2 == 0) {
                continue;
            }
            
        }
        return 0;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(3);
        hashMap.put(1,1);
        hashMap.put(2,2);
        System.out.println(hashMap.entrySet());
    }
}
