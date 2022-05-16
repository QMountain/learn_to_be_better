public class MyUtil {

    public static void main(String[] args) {
        String s = "[[1,2],[2,3],[2,10],[3,4],[4,5],[4,11],[5,1]]";
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
