package algorithm.leetcode.easy.g;

public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 == l2) {
            if (str1.equals(str2)) {
                return str1;
            }
            return "";
        }
        if (l1 < l2) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        while (true) {
            if (!str1.startsWith(str2)) {
                return "";
            }
            while (str1.startsWith(str2)) {
                str1 = str1.replaceFirst(str2,"");
            }
            if (str1.equals("")) {
                return str2;
            }
            if (str1.length() < str2.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
        }
    }

}
