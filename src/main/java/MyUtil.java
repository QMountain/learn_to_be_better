public class MyUtil {

    public static void main(String[] args) {
        String s = "[[5,6,10,14],[6,10,13,18],[10,13,18,19]]";
        s = s.trim();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                chars[i] = '{';
            }
            if (chars[i] == ']') {
                chars[i] = '}';
            }
        }
        System.out.println(new String(chars));
    }
}
