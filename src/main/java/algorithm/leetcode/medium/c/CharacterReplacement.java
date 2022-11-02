package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int length = s.length();
        List<LinkedList<Integer>> list = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(-1);
            list.add(linkedList);
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                LinkedList<Integer> indexList = list.get(j);
                if (c-'A' != j) {
                    indexList.add(i);
                }
                if (indexList.size() > k+1) {
                    Integer pollFirst = indexList.pollFirst();
                    Integer peekLast = indexList.peekLast();
                    max = Math.max(max,peekLast-pollFirst-1);
                }
                if (i == length-1) {
                    indexList.add(length);
                    Integer pollFirst = indexList.pollFirst();
                    Integer peekLast = indexList.peekLast();
                    max = Math.max(max,peekLast-pollFirst-1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        //System.out.println(7 == characterReplacement.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
        System.out.println(4 == characterReplacement.characterReplacement("AAAA", 2));
        System.out.println(4 == characterReplacement.characterReplacement("AABABBA", 1));
        System.out.println(4 == characterReplacement.characterReplacement("ABAB", 2));
    }
}
