package algorithm.leetcode.easy.a;

public class AreAlmostEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int index1 = -1;
        int index2 = -1;
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1){
                    index2 = i;
                } else {
                    return false;
                }
            }
        }
        if (index2 == -1) {
            return false;
        }
        return s1.charAt(index1) == s2.charAt(index2) &&
                s1.charAt(index2) == s2.charAt(index1);
    }

}
