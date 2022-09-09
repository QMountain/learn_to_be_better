package algorithm.leetcode.easy.s;

public class SubsetXORSum {

    // 题号 1863 找出所有子集的异或总和再求和， 当前方法是最低程度的复杂度，更优解是位运算，O(n) 即可
    public int subsetXORSum(int[] nums) {
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
