package algorithm.leetcode.easy.c;

public class CheckRecord {

    public boolean checkRecord(String s) {
        if (s.contains("LLL")) {
            return false;
        }
        if (!s.contains("A")) {
            return true;
        }
        s = s.replaceFirst("A","");
        return !s.contains("A");
    }

}
