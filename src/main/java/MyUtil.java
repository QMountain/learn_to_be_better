public class MyUtil {

    public static void main(String[] args) {
        String s = "[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]";
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
