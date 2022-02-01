package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindAnagrams
 * @Description 找到字符串中所有字母异位词
 * @Author qsf
 * Date   2021-11-28  17:04
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        if (pLength > sLength) {
            return new ArrayList<>(0);
        }

        List<Integer> result = new ArrayList<>(sLength-pLength);

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount,pCount)) {
            result.add(0);
        }

        for (int i = 0; i < sLength - pLength; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i+pLength) - 'a'];
            if (Arrays.equals(sCount,pCount)) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams.findAnagrams(s, p);
        System.out.println(anagrams);

        s = "cbaebabacd";
        p = "abc";
        List<Integer> anagrams1 = findAnagrams.findAnagrams(s, p);
        System.out.println(anagrams1);
    }
}
