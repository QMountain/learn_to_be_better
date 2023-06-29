package algorithm.leetcode.medium.r;

import java.util.ArrayList;
import java.util.List;

public class ReconstructMatrix {

    // 0 <= colsum[i] <= 2
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ansList = new ArrayList<>(2);
        ansList.add(new ArrayList<>(colsum.length));
        ansList.add(new ArrayList<>(colsum.length));
        for (int i : colsum) {
            if (i == 0) {
                ansList.get(0).add(0);
                ansList.get(1).add(0);
            } else if (i == 1) {
                if (upper > 0 && upper >= lower) {
                    ansList.get(0).add(1);
                    ansList.get(1).add(0);
                    upper--;
                } else if (lower > 0) {
                    ansList.get(0).add(0);
                    ansList.get(1).add(1);
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            } else {
                if (upper > 0 && lower > 0) {
                    ansList.get(0).add(1);
                    ansList.get(1).add(1);
                    upper--;
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            }
        }
        if (upper > 0 || lower > 0) {
            return new ArrayList<>();
        }
        return ansList;
    }

    public static void main(String[] args) {
        ReconstructMatrix reconstructMatrix = new ReconstructMatrix();
        System.out.println(reconstructMatrix.reconstructMatrix(4, 7, new int[]{2,1,2,2,1,1,1}));
        System.out.println(reconstructMatrix.reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
    }
}
