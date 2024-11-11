package algorithm.leetcode.easy.c;

public class CountKConstraintSubstrings {

    // 1 <= s.length <= 50
    // 1 <= k <= s.length
    // s[i] 是 '0' 或 '1'。
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0;
        int countZero = s.charAt(0) == '0' ? 1 : 0;
        int countOne = 1 - countZero;
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOne++;
            } else {
                countZero++;
            }
            while (countZero > k && countOne > k) {
                ans += i - left;
                if (s.charAt(left) == '1') {
                    countOne--;
                } else {
                    countZero--;
                }
                left++;
            }
        }
        ans += (s.length() - left + 1) * (s.length() - left) >> 1;
        return ans;
    }

    public static void main(String[] args) {
        CountKConstraintSubstrings countKConstraintSubstrings = new CountKConstraintSubstrings();
        System.out.println(18 == countKConstraintSubstrings.countKConstraintSubstrings(
                "000011", 1));
        System.out.println(15 == countKConstraintSubstrings.countKConstraintSubstrings(
                "11111", 1));
        System.out.println(25 == countKConstraintSubstrings.countKConstraintSubstrings(
                "1010101", 2));
        System.out.println(12 == countKConstraintSubstrings.countKConstraintSubstrings(
                "10101", 1));
    }
}
