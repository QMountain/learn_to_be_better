package algorithm.leetcode.easy.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 */
public class SubsetXORSum {

    Map<String, Integer> cache = new HashMap<>();

    // 1 <= nums.length <= 12
    // 1 <= nums[i] <= 20
    public int subsetXORSum(int[] nums) {
        int length = nums.length;
        int[] count = new int[32];
        for (int num : nums) {
            int i = 31;
            while (num > 0) {
                count[i--] += num % 2;
                num >>= 1;
            }
        }
        int ans = 0;
        int base = 1;
        for (int i = 31; i >= 0; i--) {
            int oneCount = count[i];
            int total = 0;
            for (int j = 1; j <= oneCount; j+=2) {
                int cal = cal(oneCount, j);
                total += cal;
            }
            ans += total * (1 << (length - oneCount)) * base;
            base <<= 1;
        }
        return ans;
    }

    public int cal(int m, int n) {
        String key = m + "," +n;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int val = 1;
        for (int i = 2; i <= m; i++) {
            val *= i;
        }
        for (int i = 2; i <= n; i++) {
            val /= i;
        }
        for (int i = 2; i <= m - n; i++) {
            val /= i;
        }
        cache.put(key, val);
        return val;
    }

    public int subsetXORSum3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans += nums[i];
            List<Integer> next = new ArrayList<>();
            next.add(nums[i]);
            for (Integer integer : list) {
                int n = integer ^ nums[i];
                next.add(n);
                ans += n;
            }
            list.addAll(next);
        }
        return ans;
    }

    // 题号 1863 找出所有子集的异或总和再求和， 当前方法是最低程度的复杂度，更优解是位运算，O(n) 即可
    public int subsetXORSum2(int[] nums) {
        int length = nums.length;
        int max = (1 << length) - 1;
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int xor = -1;
            String s = Integer.toBinaryString(i);
            int sl = s.length();
            int prefix = length-sl;
            for (int j = 0; j < sl; j++) {
                if (s.charAt(j) == '1') {
                    if (xor == -1) {
                        xor = nums[j+prefix];
                    } else {
                        xor ^= nums[j+prefix];
                    }
                }
            }
            ans += xor;
        }
        return ans;
    }

    public static void main(String[] args) {
        SubsetXORSum subsetXORSum = new SubsetXORSum();
        System.out.println(480 == subsetXORSum.subsetXORSum(new int[]{3,4,5,6,7,8}));
        System.out.println(28 == subsetXORSum.subsetXORSum(new int[]{5,1,6}));
        System.out.println(6 == subsetXORSum.subsetXORSum(new int[]{1,3}));
    }
}
