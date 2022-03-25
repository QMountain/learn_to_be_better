public class MyUtil {

    public static void main(String[] args) {
        String s = "[[100,200,100],[200,50,200],[100,200,100]]";
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
