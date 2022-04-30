package algorithm.leetcode.easy.k;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] counts = new int[rows];
        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            counts[i] = count;
        }
        int[] resArr = new int[k];
        int index = 0;
        Set<Integer> abandonIndex = new HashSet<>(k);
        while (index < k) {
            int min = cols+1;
            int nMinIndex = 0;
            for (int i = 0; i < rows; i++) {
                if (counts[i] < min && !abandonIndex.contains(i)) {
                    min = counts[i];
                    nMinIndex = i;
                }
            }
            abandonIndex.add(nMinIndex);
            resArr[index++] = nMinIndex;
        }
        return resArr;
    }

    public static void main(String[] args) {
        KWeakestRows kWeakestRows = new KWeakestRows();
        System.out.println(Arrays.toString(kWeakestRows.kWeakestRows(
                new int[][]{{1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}}, 3)));
    }
}
