package algorithm.leetcode.easy.l;

public class IsUnique {

    /**
     * 面试题 01.01. 判定字符是否唯一
     */
    public boolean isUnique(String astr) {
        boolean[] visited = new boolean[26];
        char[] charArray = astr.toCharArray();
        for (char c : charArray) {
            if (visited[c - 'a']) {
                return false;
            }
            visited[c - 'a'] = true;
        }
        return true;
    }

}
