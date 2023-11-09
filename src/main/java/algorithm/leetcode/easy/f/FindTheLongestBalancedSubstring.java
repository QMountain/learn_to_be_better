package algorithm.leetcode.easy.f;

public class FindTheLongestBalancedSubstring {

    // 1 <= s.length <= 50
    public int findTheLongestBalancedSubstring(String s) {
        int countZero = 0;
        int countOne = 0;
        int ans = 0;
        boolean countingZero = s.charAt(0) == '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (countingZero) {
                    countZero++;
                } else {
                    int min = Math.min(countOne, countZero);
                    ans = Math.max(ans, min*2);
                    countZero = 1;
                    countOne = 0;
                    countingZero = true;
                }
            } else {
                if (countingZero) {
                    countingZero = false;
                }
                countOne++;
                if (i == s.length()-1) {
                    int min = Math.min(countOne, countZero);
                    ans = Math.max(ans, min*2);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheLongestBalancedSubstring findTheLongestBalancedSubstring = new FindTheLongestBalancedSubstring();
        System.out.println(2 == findTheLongestBalancedSubstring.findTheLongestBalancedSubstring("01"));
        System.out.println(0 == findTheLongestBalancedSubstring.findTheLongestBalancedSubstring("111"));
        System.out.println(4 == findTheLongestBalancedSubstring.findTheLongestBalancedSubstring("00111"));
        System.out.println(6 == findTheLongestBalancedSubstring.findTheLongestBalancedSubstring("01000111"));
    }
}
