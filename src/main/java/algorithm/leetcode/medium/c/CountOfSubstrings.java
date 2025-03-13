package algorithm.leetcode.medium.c;

import java.util.*;

/**
 * 给你一个字符串 word 和一个 非负 整数 k。
 * 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，
 * 并且 恰好 包含 k 个辅音字母的子字符串的总数。
 */
public class CountOfSubstrings {

    public long count(String word, int m) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = word.length(), consonants = 0;
        long res = 0;
        Map<Character, Integer> occur = new HashMap<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && (consonants < m || occur.size() < 5)) {
                char ch = word.charAt(j);
                if (vowels.contains(ch)) {
                    occur.put(ch, occur.getOrDefault(ch, 0) + 1);
                } else {
                    consonants++;
                }
                j++;
            }
            if (consonants >= m && occur.size() == 5) {
                res += n - j + 1;
            }
            char left = word.charAt(i);
            if (vowels.contains(left)) {
                occur.put(left, occur.get(left) - 1);
                if (occur.get(left) == 0) {
                    occur.remove(left);
                }
            } else {
                consonants--;
            }
        }
        return res;
    }

    public long countOfSubstrings(String word, int k) {
        return count(word, k) - count(word, k + 1);
    }

    // 5 <= word.length <= 2 * 10^5
    // word 仅由小写英文字母组成。
    // 0 <= k <= word.length - 5
    public long countOfSubstrings3(String word, int k) {
        int length = word.length();
        TreeSet<Integer> consonantSet = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                consonantSet.add(i);
            }
        }
        int[] count = new int[6];
        int readIndex = 0;
        long ans = 0;
        for (int i = 0; i < length-k-4; i++) {
            boolean jump = false;
            for (int j = readIndex; j < length; j++) {
                char ch = word.charAt(j);
                if (ch == 'a') {
                    count[0]++;
                } else if (ch == 'e') {
                    count[1]++;
                } else if (ch == 'i') {
                    count[2]++;
                } else if (ch == 'o') {
                    count[3]++;
                } else if (ch == 'u') {
                    count[4]++;
                } else {
                    count[5]++;
                }
                readIndex = j;
                if (count[5] > k) {
                    if (!consonantSet.contains(i)) {
                        Integer higher = consonantSet.higher(i);
                        if (higher == null) {
                            return ans;
                        }
                        i = higher;
                        count = new int[6];
                        readIndex = i+1;
                        jump = true;
                    } else {
                        readIndex++;
                    }
                    break;
                } else if (count[5] == k) {
                    if (count[0] > 0 && count[1] > 0 && count[2] > 0 && count[3] > 0 && count[4] > 0) {
                        Integer higher = consonantSet.higher(j);
                        higher = Objects.requireNonNullElse(higher, length);
                        ans += higher - j;
                        if (ch == 'a') {
                            count[0]--;
                        } else if (ch == 'e') {
                            count[1]--;
                        } else if (ch == 'i') {
                            count[2]--;
                        } else if (ch == 'o') {
                            count[3]--;
                        } else if (ch == 'u') {
                            count[4]--;
                        } else {
                            count[5]--;
                        }
                        break;
                    }
                } else if (j == length-1) {
                    return ans;
                }
            }
            if (jump) {
                continue;
            }
            char c = word.charAt(i);
            if (c == 'a') {
                count[0]--;
            } else if (c == 'e') {
                count[1]--;
            } else if (c == 'i') {
                count[2]--;
            } else if (c == 'o') {
                count[3]--;
            } else if (c == 'u') {
                count[4]--;
            } else {
                count[5]--;
            }
        }
        return ans;
    }

    // 5 <= word.length <= 250
    // word 仅由小写英文字母组成。
    // 0 <= k <= word.length - 5
    public int countOfSubstrings2(String word, int k) {
        int length = word.length();
        int[] count = new int[6];
        int readIndex = 0;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = readIndex; j < length; j++) {
                readIndex = j;
                cal(count, word.charAt(j), 1);
                if (isOk(count, k)) {
                    ans++;
                    cal(count, word.charAt(j), -1);
                    for (int l = j+1; l < length; l++) {
                        char c = word.charAt(l);
                        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                            break;
                        } else {
                            ans++;
                        }
                    }
                    break;
                } else if (j == length - 1) {
                    return ans;
                } else if (count[5] > k) {
                    cal(count, word.charAt(j), -1);
                    break;
                }
            }
            cal(count, word.charAt(i), -1);
        }
        return ans;
    }

    public void cal(int[] count, char c, int num) {
        if (c == 'a') {
            count[0] += num;
        } else if (c == 'e') {
            count[1] += num;
        } else if (c == 'i') {
            count[2] += num;
        } else if (c == 'o') {
            count[3] += num;
        } else if (c == 'u') {
            count[4] += num;
        } else {
            count[5] += num;
        }
    }

    public boolean isOk(int[] count, int k) {
        return count[0] >= 1 && count[1] >= 1 && count[2] >= 1 && count[3] >= 1 && count[4] >= 1 && count[5] == k;
    }

    public static void main(String[] args) {
        CountOfSubstrings countOfSubstrings = new CountOfSubstrings();
        System.out.println(1 == countOfSubstrings.countOfSubstrings("buoeia", 0));
        System.out.println(3 == countOfSubstrings.countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(3 == countOfSubstrings.countOfSubstrings("iqeaouqi", 2));
        System.out.println(10 == countOfSubstrings.countOfSubstrings("aaeuoiouee", 0));
        System.out.println(2 == countOfSubstrings.countOfSubstrings("ieiaoud", 0));

        System.out.println(1 == countOfSubstrings.countOfSubstrings("aeiou", 0));
        System.out.println(0 == countOfSubstrings.countOfSubstrings("aeioqq", 1));
    }

}
