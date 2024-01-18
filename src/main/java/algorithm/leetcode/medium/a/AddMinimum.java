package algorithm.leetcode.medium.a;

public class AddMinimum {

    // 1 <= word.length <= 50
    // word 仅由字母 "a"、"b" 和 "c" 组成
    public int addMinimum(String word) {
        if (word.length() < 2) {
            return 3 - word.length();
        }
        if (word.charAt(0) >= word.charAt(1)) {
            return 2 + addMinimum(word.substring(1));
        }
        if (word.charAt(0) == 'a' && word.charAt(1) == 'b') {
            if (word.length() == 2) {
                return 1;
            }
            if (word.charAt(2) == 'c') {
                if (word.length() > 3) {
                    return addMinimum(word.substring(3));
                }
                return 0;
            }
            return 1 + addMinimum(word.substring(2));
        }
        if (word.length() > 2) {
            return 1 + addMinimum(word.substring(2));
        }
        return 1;
    }

    public static void main(String[] args) {
        AddMinimum addMinimum = new AddMinimum();
        System.out.println(9 == addMinimum.addMinimum("aaaaac"));
        System.out.println(2 == addMinimum.addMinimum("b"));
        System.out.println(6 == addMinimum.addMinimum("aaa"));
        System.out.println(0 == addMinimum.addMinimum("abc"));
    }
}
