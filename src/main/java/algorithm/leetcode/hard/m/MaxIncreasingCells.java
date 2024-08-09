package algorithm.leetcode.hard.m;

import java.util.*;

public class MaxIncreasingCells {

    public int maxIncreasingCells(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        TreeMap<Integer, List<int[]>> totalMap = new TreeMap<>();
        TreeMap<Integer, List<int[]>>[] rowsMap = new TreeMap[rows];
        TreeMap<Integer, List<int[]>>[] colsMap = new TreeMap[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[] p = new int[]{i, j};
                List<int[]> list1 = rowsMap[i].getOrDefault(mat[i][j], new ArrayList<>());
                list1.add(p);
                rowsMap[i].put(i, list1);

                List<int[]> list2 = colsMap[j].getOrDefault(mat[i][j], new ArrayList<>());
                list2.add(p);
                colsMap[j].put(j, list2);

                List<int[]> list = totalMap.getOrDefault(mat[i][j], new ArrayList<>());
                list.add(p);
                totalMap.put(mat[i][j], list);
            }
        }
        Map<String, Integer> searchedMap = new HashMap<>();
        List<int[]> value = totalMap.pollLastEntry().getValue();
        for (int[] arr : value) {
            String key = arr[0] + "," + arr[1];
            searchedMap.put(key, 1);
        }
        while (!totalMap.isEmpty()) {
            List<int[]> list = totalMap.pollLastEntry().getValue();
            for (int[] arr : list) {
                int v = mat[arr[0]][arr[1]];
                SortedMap<Integer, List<int[]>> tailMap = rowsMap[arr[0]].tailMap(v + 1);
                if (!tailMap.isEmpty()) {
                    for (Map.Entry<Integer, List<int[]>> entry : tailMap.entrySet()) {
                        List<int[]> value1 = entry.getValue();
                    }
                }
            }
        }
        return 0;
    }

}
