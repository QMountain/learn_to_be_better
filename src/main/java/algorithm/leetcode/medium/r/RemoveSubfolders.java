package algorithm.leetcode.medium.r;

import java.util.*;

public class RemoveSubfolders {

    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        List<String> ansList = new ArrayList<>();
        for (String f : folder) {
            String copy = new String(f.toCharArray());
            boolean isSub = false;
            while (true) {
                int index = copy.lastIndexOf("/");
                if (index == 0) {
                    break;
                }
                copy = copy.substring(0,index);
                if (set.contains(copy)) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                ansList.add(f);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        RemoveSubfolders removeSubfolders = new RemoveSubfolders();
        System.out.println(removeSubfolders.removeSubfolders(
                new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
        System.out.println(removeSubfolders.removeSubfolders(
                new String[]{"/a","/a/b/c","/a/b/d"}));
        System.out.println(removeSubfolders.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }
}
