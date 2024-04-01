package algorithm.leetcode.easy.f;

public class FinalString {

    // 1 <= s.length <= 100
    // s 由小写英文字母组成
    // s[0] != 'i'
    public String finalString(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                count++;
            } else {
                if (count % 2 == 0) {
                    sb.append(s.charAt(i));
                } else {
                    sb.insert(0, s.charAt(i));
                }
            }
        }
        if (count % 2 == 0) {
            return sb.toString();
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        FinalString finalString = new FinalString();
        System.out.println("wvf".equals(finalString.finalString("viwif")));
        System.out.println("ponter".equals(finalString.finalString("poiinter")));
        System.out.println("rtsng".equals(finalString.finalString("string")));
    }
}
