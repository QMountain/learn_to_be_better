package algorithm.leetcode.easy;

public class CountSegments {

    public int countSegments(String s) {
        int res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ') {
                for (int j = i; j < length; j++) {
                    if (j == length-1) {
                        res++;
                        return res;
                    }
                    if (s.charAt(j) == ' ') {
                        res++;
                        i = j;
                        break;
                    }

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSegments countSegments = new CountSegments();
        System.out.println(countSegments.countSegments("Hello, my name is John"));
    }
}
