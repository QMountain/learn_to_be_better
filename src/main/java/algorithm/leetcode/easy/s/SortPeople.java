package algorithm.leetcode.easy.s;

import java.util.Arrays;

public class SortPeople {

    public String[] sortPeople(String[] names, int[] heights) {
        int length = names.length;
        String[][] arr = new String[length][2];
        for (int i = 0; i < length; i++) {
            arr[i][0] = heights[i]+"";
            arr[i][1] = names[i];
        }
        Arrays.sort(arr,(a,b)-> Integer.parseInt(b[0])-Integer.parseInt(a[0]));
        for (int i = 0; i < length; i++) {
            names[i] = arr[i][1];
        }
        return names;
    }

}
