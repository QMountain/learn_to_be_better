package algorithm.leetcode.easy.m;

/**
 * @ClassName MaxPower
 * @Description 连续字符
 * @Author qsf
 * Date   2021-12-09  23:03
 */
public class MaxPower {

    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        int maxLength = 0;
        int l = 1;
        while (right < s.length()) {
            if (s.charAt(right) == s.charAt(left)) {
                l++;
            } else {
                l = 1;
                left = right;
            }
            right++;
            maxLength = Math.max(maxLength,l);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MaxPower maxPower = new MaxPower();

        int i = maxPower.maxPower("leetcode");
        System.out.println(i);

        int i1 = maxPower.maxPower("abbcccddddeeeeedcba");
        System.out.println(i1);
    }
}
