public class MyUtil {

    public static void main(String[] args) {
        /*String s = "[[10,60],[20,30],[30,30],[60,40]]";
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
        System.out.println(new String(chars));*/
        MyUtil.StringToChar();
    }

    public static void StringToChar() {
        String s = "[[1,1,1,1,-1,-1,-1,1,0,0],[1,0,0,0,1,0,0,0,1,0],[0,0,1,1,1,1,0,1,1,1],[1,1,0,1,1,1,0,-1,1,1],[0,0,0,0,1,-1,0,0,1,-1],[1,0,1,1,1,0,0,-1,1,0],[1,1,0,1,0,0,1,0,1,-1],[1,-1,0,1,0,0,0,1,-1,1],[1,0,-1,0,-1,0,0,1,0,0],[0,0,-1,0,1,0,1,0,0,1]]";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                chars[i] = '{';
            }
            if (chars[i] == ']') {
                chars[i] = '}';
            }
            if (chars[i] == '"') {
                chars[i] = '\'';
            }
        }
        System.out.println(new String(chars));
    }
}
