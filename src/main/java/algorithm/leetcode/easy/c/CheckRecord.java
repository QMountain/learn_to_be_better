package algorithm.leetcode.easy.c;

public class CheckRecord {

    public boolean checkRecord(String s) {
        int countA = 0;
        int countContinuousL = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countContinuousL = 0;
                if (++countA >= 2) {
                    return false;
                }
            } else if (c == 'L') {
                if (++countContinuousL >= 3) {
                    return false;
                }
            } else {
                countContinuousL = 0;
            }
        }
        return true;
    }

    public boolean checkRecord2(String s) {
        if (s.contains("LLL")) {
            return false;
        }
        if (!s.contains("A")) {
            return true;
        }
        s = s.replaceFirst("A","");
        return !s.contains("A");
    }

    public static void main(String[] args) {
        CheckRecord checkRecord = new CheckRecord();
        System.out.println(checkRecord.checkRecord("LALL"));
    }
}
