public class MyUtil {

    public static void main(String[] args) {
        String s = "[[0,0],[1,1],[0,0],[2,0],[2,2],[1,1],[2,1],[0,1],[0,1]]";
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
