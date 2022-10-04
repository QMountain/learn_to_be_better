package algorithm.leetcode.medium.m;

public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        int countLeft = 0;
        int countRight = 0;
        int length = s.length();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                countLeft++;
            } else {
                countRight++;
            }
            if (countRight > countLeft) {
                ans++;
                countRight--;
            }
        }
        return ans + countLeft - countRight;
    }

    public static void main(String[] args) {
        MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();
        System.out.println(3 == minAddToMakeValid.minAddToMakeValid("((("));
        System.out.println(1 == minAddToMakeValid.minAddToMakeValid("())"));
    }
}
