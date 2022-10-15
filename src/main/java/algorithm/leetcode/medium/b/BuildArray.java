package algorithm.leetcode.medium.b;

import java.util.LinkedList;
import java.util.List;

public class BuildArray {

    public List<String> buildArray(int[] target, int n) {
        int current = 1;
        List<String> list = new LinkedList<>();
        for (int j : target) {
            if (j == current) {
                list.add("Push");
                current++;
            } else if (j > current) {
                while (j > current) {
                    list.add("Push");
                    list.add("Pop");
                    current++;
                }
                list.add("Push");
                current++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BuildArray buildArray = new BuildArray();
        System.out.println(buildArray.buildArray(new int[]{1, 2}, 4));
        System.out.println(buildArray.buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(buildArray.buildArray(new int[]{1, 3}, 3));
    }
}
