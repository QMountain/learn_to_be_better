package algorithm.leetcode.easy.l;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].trim().length();
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(5 == lengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(4 == lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(6 == lengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
    }
}
