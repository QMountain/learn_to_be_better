package algorithm.leetcode.easy.t;

/**
 * @ClassName ToLowerCase
 * @Description 转换成小写字母
 * @Author qsf
 * Date   2021-12-12  15:31
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 65 && c <= 90) {
                chars[i] = (char) (c+32);
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');

        ToLowerCase toLowerCase = new ToLowerCase();
        String s = toLowerCase.toLowerCase("Hello");
        System.out.println(s);
        String s1 = toLowerCase.toLowerCase("here");
        System.out.println(s1);
    }
}
