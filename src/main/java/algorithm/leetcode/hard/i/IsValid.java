package algorithm.leetcode.hard.i;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsValid {

    // 不通过
    public boolean isValid2(String code) {
        if (code.contains("<![CDATA[") && code.contains("]]>")) {
            int i1 = code.indexOf("<![CDATA[");
            int i2 = code.indexOf("]]>");
            if (i2 - i1 > 8) {
                String s1 = code.substring(0, i1);
                String s2 = code.substring(i2+3);
                code = s1 + s2;
            }
            if (code.equals("")) {
                return true;
            }
        }
        if (!code.startsWith("<") || !code.endsWith(">")) {
            return false;
        }
        int length = code.length();
        int leftIndex = -1;
        for (int i = 1; i < length; i++) {
            if (code.charAt(i) == '>') {
                leftIndex = i;
                break;
            }
            if (!Character.isUpperCase(code.charAt(i))) {
                return false;
            }
        }
        if (leftIndex == -1 || leftIndex == length-1 || leftIndex > 9) {
            return false;
        }
        int rightIndex = length;
        for (int j = length-2; j > 0; j--) {
            if (code.charAt(j) == '/' && code.charAt(j-1) == '<') {
                rightIndex = j;
                break;
            }
            if (!Character.isUpperCase(code.charAt(j))) {
                return false;
            }
        }
        if (rightIndex < 3 || rightIndex == length || length-1-rightIndex > 9) {
            return false;
        }
        String s1 = code.substring(1, leftIndex);
        String s2 = code.substring(rightIndex+1, length - 1);
        if (!s1.equals(s2)) {
            return false;
        }
        String substring = code.substring(leftIndex + 1, rightIndex - 1);
        if (substring.equals("")) {
            return true;
        }
        for (int i = leftIndex+1; i <= rightIndex-2; i++) {
            if (code.charAt(i) == '<') {
                leftIndex = i;
                break;
            }
            if (i == rightIndex-2 && code.charAt(i) != '<') {
                return true;
            }
        }
        for (int i = rightIndex-2; i > leftIndex; i--) {
            char c = code.charAt(i);
            if (c == '>') {
                rightIndex = i;
                break;
            }
        }
        return isValid(code.substring(leftIndex,rightIndex+1));
    }

    // 官方题解  栈
    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> tags = new ArrayDeque<String>();

        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                if (code.charAt(i + 1) == '/') {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 2, j);
                    if (tags.isEmpty() || !tags.peek().equals(tagname)) {
                        return false;
                    }
                    tags.pop();
                    i = j + 1;
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 1, j);
                    if (tagname.length() < 1 || tagname.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < tagname.length(); ++k) {
                        if (!Character.isUpperCase(tagname.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagname);
                    i = j + 1;
                }
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }

        return tags.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("<A><A>456</A>  <A> 123  !!  <![CDATA[]]>  123 </A>   <A>123</A></A>"));
        System.out.println(isValid.isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"));
        System.out.println(isValid.isValid("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"));
        System.out.println(isValid.isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));
        System.out.println(isValid.isValid("<DIV>  unmatched <  </DIV>"));
        System.out.println(isValid.isValid("<DIV>  div tag is not closed  <DIV>"));
        System.out.println(isValid.isValid("<A>  <B> </A>   </B>"));
        System.out.println(isValid.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(isValid.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }
}
