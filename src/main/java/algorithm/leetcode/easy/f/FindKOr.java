package algorithm.leetcode.easy.f;

public class FindKOr {

    public int findKOr(int[] nums, int k) {
        int[] countArr = new int[32];
        for (int num : nums) {
            int index = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    countArr[index]++;
                }
                index++;
                num >>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (countArr[i] >= k) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindKOr findKOr = new FindKOr();
        System.out.println(findKOr.findKOr(new int[]{7,12,9,8,9,15}, 4));
    }
}
