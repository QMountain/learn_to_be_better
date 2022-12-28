package algorithm.leetcode.medium.m;

public class MinimumLength {

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            while (left + 1 < right && s.charAt(left+1) == s.charAt(right)) {
                left++;
            }
            while (right - 1 > left && s.charAt(right-1) == s.charAt(left)) {
                right--;
            }
            left++;
            right--;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        MinimumLength minimumLength = new MinimumLength();
        System.out.println(3 == minimumLength.minimumLength("aabccabba"));
        System.out.println(0 == minimumLength.minimumLength("cabaabac"));
        System.out.println(2 == minimumLength.minimumLength("ca"));
    }
}
