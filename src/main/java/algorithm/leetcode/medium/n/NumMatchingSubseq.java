package algorithm.leetcode.medium.n;

import java.util.Arrays;

public class NumMatchingSubseq {

    public int numMatchingSubseq(String s, String[] words) {
        int length = s.length();
        int[][] index = new int[length][26];
        Arrays.fill(index[length-1],-1);
        index[length-1][s.charAt(length-1)-'a'] = length-1;
        for (int i = length-2; i >= 0; i--) {
            char c = s.charAt(i);
            System.arraycopy(index[i+1],0,index[i],0,26);
            index[i][c-'a'] = i;
        }
        int ans = 0;
        for (String word : words) {
            boolean add = true;
            int wl = word.length();
            int wi = -1;
            for (int i = 0; i < wl; i++) {
                char c = word.charAt(i);
                if (wi + 1 == length) {
                    add = false;
                    break;
                }
                wi = index[wi+1][c-'a'];
                if (wi == -1) {
                    add = false;
                    break;
                }
            }
            if (add) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumMatchingSubseq numMatchingSubseq = new NumMatchingSubseq();
        System.out.println(2 == numMatchingSubseq.numMatchingSubseq("iwdlcxpyagegrcnrcylxolxlnhhwnxyzltiscrjztiivnpnzlubzpueihinsqdfvypdteztiodbhaqhxskupwulvkzhczdyoouym", new String[]{"hhwnxyzltiscrjztiivnpnzlubzpueihinsqdfvyp","vnpnzlubzpueihinsqdfvypdteztiodbha","rcnrcylxolxlnhhwnxyzltiscrjztiivnpnzlubzpueihi","dfvypdteztiodbhaqhxskupwulvk","zltiscrjztii","wdmbatbcewwittubryrqwwrvfkrmniomofygybeqfzusrgeart","myzfexqmzxnbmmnhmpbddqhrwrobqzjiwdzzpyzodejysuuquc","wxvrcbihbasohfvuwuxleesqeujxvjfvgwnhltenbspdgzsdrs","nztyysfhfbfcihyeaqdarqxfpjunevabzafvbmpbtenarvyizv","nivufheyodfjuggrbndyojeahrzgptikjfqufhwyhzyyjteahx"}));
        System.out.println(2 == numMatchingSubseq.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
        System.out.println(3 == numMatchingSubseq.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }
}
