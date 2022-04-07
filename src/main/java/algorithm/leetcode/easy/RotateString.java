package algorithm.leetcode.easy;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        int sl = s.length();
        int gl = goal.length();
        if (sl != gl) {
            return false;
        }
        for (int i = 0; i < sl; i++) {
            String ng = s.substring(i, sl) + s.substring(0, i);
            if (ng.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString("abcde", "cdeab"));
    }
}
