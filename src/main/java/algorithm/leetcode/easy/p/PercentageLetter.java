package algorithm.leetcode.easy.p;

/**
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 */
public class PercentageLetter {

    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }

    public static void main(String[] args) {
        PercentageLetter percentageLetter = new PercentageLetter();
        System.out.println(33 == percentageLetter.percentageLetter("foobar", 'o'));
    }
}
