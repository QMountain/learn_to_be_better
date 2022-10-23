package algorithm.leetcode.medium.l;

public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        int length = s.length();
        int[][] count = new int[length+1][26];
        for (int i = 1; i <= length; i++) {
            System.arraycopy(count[i-1],0,count[i],0,26);
            count[i][s.charAt(i-1)-'a']++;
        }
        for (int i = length; i > 0; i--) {
            for (int startIndex = 0; startIndex <= length - i; startIndex++) {
                int[] start = count[startIndex];
                int[] end = count[i+startIndex];
                boolean success = true;
                for (int j = 0; j < 26; j++) {
                    int c = end[j] - start[j];
                    if (c == 0) {
                        continue;
                    }
                    if (c < k) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(5 == longestSubstring.longestSubstring("ababbc", 2));
        System.out.println(3 == longestSubstring.longestSubstring("aaabb", 3));
    }
}
