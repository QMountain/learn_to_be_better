package algorithm.leetcode.easy;

import java.util.Objects;

public class FindLUSlength {

    public int findLUSlength(String a, String b) {
        if (Objects.equals(a,b)) {
            return -1;
        }
        return Math.max(a.length(),b.length());
    }

    public static void main(String[] args) {
        FindLUSlength findLUSlength = new FindLUSlength();
        System.out.println(3 == findLUSlength.findLUSlength("aba", "cdc"));
        System.out.println(3 == findLUSlength.findLUSlength("aaa", "bbb"));
        System.out.println(-1 == findLUSlength.findLUSlength("aaa", "aaa"));
    }
}
