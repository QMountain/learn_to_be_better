package algorithm.leetcode.medium.f;

import java.util.Arrays;

public class FindReplaceString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int length = indices.length;
        int[][] indexArr = new int[length][2];
        for (int i = 0; i < length; i++) {
            indexArr[i][0] = i;
            indexArr[i][1] = indices[i];
        }
        Arrays.sort(indexArr, (a,b)-> b[1] - a[1]);
        for (int[] ints : indexArr) {
            int index = ints[0];
            String source = sources[index];
            String target = targets[index];
            if (ints[1] + source.length() > s.length()) {
                continue;
            }
            String substring = s.substring(ints[1], ints[1] + source.length());
            if (source.equals(substring)) {
                s = s.substring(0, ints[1]) + target + s.substring(ints[1] + source.length());
            }
        }
        return s;
    }

    public static void main(String[] args) {
        FindReplaceString findReplaceString = new FindReplaceString();
        System.out.println(findReplaceString.findReplaceString("abcde", new int[]{2,2},
                new String[]{"cdef","bc"}, new String[]{"f","fe"}).equals("eeecd"));
        System.out.println(findReplaceString.findReplaceString("abcd", new int[]{0, 2},
                new String[]{"ab","ec"}, new String[]{"eee", "ffff"}).equals("eeecd"));
        System.out.println(findReplaceString.findReplaceString("abcd", new int[]{0, 2},
                new String[]{"a", "cd"}, new String[]{"eee", "ffff"}).equals("eeebffff"));
    }
}
