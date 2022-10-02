package algorithm.leetcode.easy.c;

public class CheckPermutation {

    public boolean checkPermutation(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 != length2) {
            return false;
        }
        int[] arr1 = new int[26];
        for (int i = 0; i < length1; i++) {
            arr1[s1.charAt(i)-'a']++;
        }
        int[] arr2 = new int[26];
        for (int i = 0; i < length2; i++) {
            arr2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
