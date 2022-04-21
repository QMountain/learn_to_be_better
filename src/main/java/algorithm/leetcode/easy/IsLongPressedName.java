package algorithm.leetcode.easy;

public class IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int nl = name.length();
        int tl = typed.length();
        if (nl > tl) {
            return false;
        }
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int index = 1;
        for (int i = 1; i < nl; i++) {
            char cn = name.charAt(i);
            boolean notFind = true;
            for (int j = index; j < tl; j++) {
                char ct = typed.charAt(j);
                if (ct == cn) {
                    index = j+1;
                    notFind = false;
                    break;
                }
                if (ct == name.charAt(i-1)) {
                    index++;
                } else {
                    return false;
                }
            }
            if (notFind) {
                return false;
            }
        }
        for (int i = index; i < tl; i++) {
            if (typed.charAt(i) != typed.charAt(index-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsLongPressedName isLongPressedName = new IsLongPressedName();
        System.out.println(isLongPressedName.isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(isLongPressedName.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName.isLongPressedName("alex", "aaleex"));
    }
}
