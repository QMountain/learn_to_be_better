package algorithm.leetcode.medium.p;

import java.util.*;

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] pacificOcean = new int[m][n];
        for (int i = 0; i < m; i++) {
            pacificOcean[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            pacificOcean[0][i] = 1;
        }

        while (true) {
            boolean goNext = false;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (pacificOcean[i][j] != 1) {
                        // to up
                        if (heights[i][j] >= heights[i-1][j] && pacificOcean[i-1][j] == 1) {
                            pacificOcean[i][j] = 1;
                            goNext = true;
                        } else if (i < m-1 && heights[i][j] >= heights[i+1][j] && pacificOcean[i+1][j] == 1) {
                            // to down
                            pacificOcean[i][j] = 1;
                            goNext = true;
                        } else if (heights[i][j] >= heights[i][j-1] && pacificOcean[i][j-1] == 1) {
                            // to left
                            pacificOcean[i][j] = 1;
                            goNext = true;
                        } else if (j < n-1 && heights[i][j] >= heights[i][j+1] && pacificOcean[i][j+1] == 1) {
                            // to right
                            pacificOcean[i][j] = 1;
                            goNext = true;
                        }
                    }
                }
            }
            if (!goNext) {
                break;
            }
        }

        int[][] atlanticOcean = new int[m][n];
        for (int i = 0; i < m; i++) {
            atlanticOcean[i][n-1] = 1;
        }
        for (int i = 0; i < n; i++) {
            atlanticOcean[m-1][i] = 1;
        }
        while (true) {
            boolean goNext = false;
            for (int i = m-2; i >= 0; i--) {
                for (int j = n-2; j >= 0; j--) {
                    if (atlanticOcean[i][j] != 1) {
                        // to up
                        if (i > 0 && heights[i][j] >= heights[i-1][j] && atlanticOcean[i-1][j] == 1) {
                            atlanticOcean[i][j] = 1;
                            goNext = true;
                        } else if (heights[i][j] >= heights[i+1][j] && atlanticOcean[i+1][j] == 1) {
                            // to down
                            atlanticOcean[i][j] = 1;
                            goNext = true;
                        } else if (j > 0 && heights[i][j] >= heights[i][j-1] && atlanticOcean[i][j-1] == 1) {
                            // to left
                            atlanticOcean[i][j] = 1;
                            goNext = true;
                        } else if (heights[i][j] >= heights[i][j+1] && atlanticOcean[i][j+1] == 1) {
                            // to right
                            atlanticOcean[i][j] = 1;
                            goNext = true;
                        }
                    }
                }
            }
            if (!goNext) {
                break;
            }
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificOcean[i][j] == 1 && atlanticOcean[i][j] == 1) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(i);
                    list.add(j);
                    resList.add(list);
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        System.out.println(pacificAtlantic.pacificAtlantic(new int[][]{{1,2,3},{8,9,4},{7,6,5}}));
        System.out.println(pacificAtlantic.pacificAtlantic(new int[][]{{1,1},{1,1},{1,1}}));
        System.out.println(pacificAtlantic.pacificAtlantic(new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}}));

        System.out.println(pacificAtlantic.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }
}
