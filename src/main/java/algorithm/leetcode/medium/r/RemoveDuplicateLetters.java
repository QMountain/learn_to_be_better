package algorithm.leetcode.medium.r;

public class RemoveDuplicateLetters {

    // 题号316，去除重复字母，官解，单调栈
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

    // 5%
    public String removeDuplicateLetters2(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                int i1 = s.indexOf(i+'a');
                int[] countSub = new int[26];
                for (int j = 0; j < i1; j++) {
                    countSub[s.charAt(j)-'a']++;
                }
                boolean canAllCut = true;
                for (int j = 0; j < 26; j++) {
                    if (countSub[j] == 0) {
                        continue;
                    }
                    if(arr[j] > countSub[j]) {
                        continue;
                    }
                    canAllCut = false;
                }
                if (canAllCut) {
                    return (char) (i + 'a') + removeDuplicateLetters(s.substring(i1+1).replaceAll((char) (i + 'a')+"",""));
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println("abc".equals(removeDuplicateLetters.removeDuplicateLetters("abacb")));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
        System.out.println("abc".equals(removeDuplicateLetters.removeDuplicateLetters("bcabc")));
    }
}
