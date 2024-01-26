package algorithm.leetcode.easy.s;

import java.util.List;

public class SumIndicesWithKSetBits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            int num = i;
            while (num != 0 && count < k) {
                if (num % 2 == 1) {
                    count++;
                }
                num >>= 1;
            }
            if (num == 0 && count == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1431655765));
        System.out.println(Integer.toBinaryString(858993459));
        System.out.println(Integer.toBinaryString(252645135));
    }
}
