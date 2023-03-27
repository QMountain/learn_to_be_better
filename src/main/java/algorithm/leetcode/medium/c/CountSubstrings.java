package algorithm.leetcode.medium.c;

public class CountSubstrings {

    public int countSubstrings(String s) {
        int length = s.length();
        int count = length;
        for (int i = 1; i < length-1; i++) {
            int maxLength = Math.min(i,length-i-1);
            for (int j = 1; j <= maxLength; j++) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < length-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                count++;
                int maxLength = Math.min(i,length-i-2);
                for (int j = 1; j <= maxLength; j++) {
                    if (s.charAt(i-j) == s.charAt(i+1+j)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    // 题号：1638 统计只差一个字符的子串数目
    // 1 <= s.length, t.length <= 100
    // s 和 t 都只包含小写英文字母。
    public int countSubstrings(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int ans = 0;
        // i  s的起始index
        for (int i = 0; i < sl; i++) {
            // j  t的起始index
            for (int j = 0; j < tl; j++) {
                int si = i;
                int ti = j;
                boolean find = false;
                while (si < sl && ti < tl) {
                    if (s.charAt(si) == t.charAt(ti)) {
                        if (find) {
                            ans++;
                        }
                    } else {
                        if (find) {
                            break;
                        } else {
                            find = true;
                            ans++;
                        }
                    }
                    si++;
                    ti++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(10 == countSubstrings.countSubstrings("abe", "bbc"));
        System.out.println(0 == countSubstrings.countSubstrings("a", "a"));
        System.out.println(3 == countSubstrings.countSubstrings("ab", "bb"));
        System.out.println(6 == countSubstrings.countSubstrings("aba", "baba"));


        System.out.println(countSubstrings.countSubstrings("aaaaa"));
        System.out.println(6 == countSubstrings.countSubstrings("aaa"));
        System.out.println(3 == countSubstrings.countSubstrings("abc"));
    }
}
