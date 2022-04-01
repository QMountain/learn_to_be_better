package algorithm.leetcode.hard;

public class MinDistance {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int maxMatch = 0;
        for (int i = 0; i < l1; i++) {
            int match = 0;
            int fromIndex = 0;
            for (int j = i; j < l1; j++) {
                char c1 = word1.charAt(j);
                int index = word2.indexOf(c1 + "", fromIndex);
                if (j == i && index == -1) {
                    break;
                } else {
                    if (index != -1) {
                        match++;
                        maxMatch = Math.max(maxMatch,match);
                        fromIndex = index+1;
                    }
                }
            }
        }
        int l2 = word2.length();
        if (l1 >= l2) {
            return l1-maxMatch;
        }
        return l2 - l1 - maxMatch;
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(1 == minDistance.minDistance("", "a"));
        System.out.println(5 == minDistance.minDistance("intention", "execution"));
        System.out.println(3 == minDistance.minDistance("horse", "ros"));

    }
}
