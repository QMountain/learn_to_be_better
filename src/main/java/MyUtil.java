import java.util.ArrayList;
import java.util.List;

public class MyUtil {

    int divider = 1000_000_007;

    public static void main(String[] args) {
        String s = "[[1,1],[-2,-2],[-2,2]]";
        s = s.trim();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                chars[i] = '{';
            }
            if (chars[i] == ']') {
                chars[i] = '}';
            } /*else if (chars[i] == '\"') {
                chars[i] = '\'';
            }*/
        }
        System.out.println(new String(chars));
        //MyUtil.StringToChar();
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

    public static void arrayToList() {
        String[][] arr = new String[][]{};
        List<List<String>> res = new ArrayList<>(arr.length);
        for (String[] strings : arr) {
            List<String> list = new ArrayList<>(strings.length);
            for (String string : strings) {
                list.add(string);
            }
            res.add(list);
        }

    }
}
