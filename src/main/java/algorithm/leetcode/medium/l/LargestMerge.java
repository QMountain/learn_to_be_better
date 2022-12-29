package algorithm.leetcode.medium.l;

public class LargestMerge {

    public String largestMerge(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 < l1 || p2 < l2) {
            String s1 = word1.substring(p1);
            String s2 = word2.substring(p2);
            if (p1 == l1) {
                sb.append(s2);
                return sb.toString();
            }
            if (p2 == l2) {
                sb.append(s1);
                return sb.toString();
            }
            int compare = compare(s1, s2);
            if (compare == 0) {
                return sb.append(s1).append(s2).toString();
            } else if (compare > 0) {
                sb.append(word1, p1, p1+compare);
                p1 += compare;
            } else {
                sb.append(word2, p2, p2-compare);
                p2 -= compare;
            }
        }
        return sb.toString();
    }

    public int compare(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == l2) {
            for (int i = 0; i < l1; i++) {
                if (word1.charAt(i) > word2.charAt(i)) {
                    return 1;
                } else if (word1.charAt(i) < word2.charAt(i)) {
                    return -1;
                }
            }
            return 1;
        }
        int length = Math.min(l1, l2);
        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) > word2.charAt(i)) {
                return 1;
            } else if (word1.charAt(i) < word2.charAt(i)) {
                return -1;
            }
        }
        int compare = compare(word1 + word2, word2 + word1);
        if (compare > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LargestMerge largestMerge = new LargestMerge();
        System.out.println("uuuurruuuruuuuuuuuruuuuurrrurrrrrrrruurrrurrrurrrrruu".equals(largestMerge.largestMerge("uuurruuuruuuuuuuuruuuuu", "urrrurrrrrrrruurrrurrrurrrrruu")));
        System.out.println("guguuuuuuuuuuuuuuguguuuuguugguggggggguuggguuggggggg".equals(largestMerge.largestMerge("guguuuuuuuuuuuuuuguguuuuguug", "gguggggggguuggguugggggg")));
        System.out.println("abdcabcabcaba".equals(largestMerge.largestMerge("abcabc", "abdcaba")));
        System.out.println("cbcabaaaaa".equals(largestMerge.largestMerge("cabaa", "bcaaa")));
    }
}
