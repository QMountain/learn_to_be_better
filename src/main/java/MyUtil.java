public class MyUtil {

    public static void main(String[] args) {
        String s = "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]";
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
