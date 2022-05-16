package algorithm.leetcode.medium.o;

public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        int fl = first.length();
        int sl = second.length();
        if (Math.abs(fl-sl) > 1) {
            return false;
        }
        if (fl == sl) {
            int diffCount = 0;
            for (int i = 0; i < fl; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diffCount++;
                }
            }
            return diffCount <= 1;
        }
        if (fl > sl) {
            int diffCount = 0;
            for (int i = 0, j = 0; i < fl && j < sl;) {
                if (first.charAt(i) != second.charAt(j)) {
                    i++;
                    diffCount++;
                } else {
                    i++;
                    j++;
                }
            }
            return diffCount <= 1;
        }
        int diffCount = 0;
        for (int i = 0, j = 0; i < fl && j < sl;) {
            if (first.charAt(i) != second.charAt(j)) {
                j++;
                diffCount++;
            } else {
                i++;
                j++;
            }
        }
        return diffCount <= 1;
    }

}
