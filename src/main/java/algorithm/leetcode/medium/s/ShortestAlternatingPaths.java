package algorithm.leetcode.medium.s;

import java.util.*;

public class ShortestAlternatingPaths {

    public int[] shortestAlternatingPaths2(int n, int[][] redEdges, int[][] blueEdges) {
        // 先红后蓝
        int[][] ans = new int[n][2];
        for (int[] an : ans) {
            Arrays.fill(an,-1);
        }
        ans[0][0] = 0;
        ans[0][1] = 0;
        Set<Integer> startPointSet = new HashSet<>();
        startPointSet.add(0);
        boolean go = true;
        List<int[]> redEdgeList = new ArrayList<>(Arrays.asList(redEdges));
        List<int[]> blueEdgeList = new ArrayList<>(Arrays.asList(blueEdges));
        while (go && (!redEdgeList.isEmpty() || !blueEdgeList.isEmpty())) {
            boolean redAdd = false;
            Set<Integer> nextStartPointSet = new HashSet<>();
            for (int[] edge : redEdgeList) {
                if (startPointSet.contains(edge[0]) && ans[edge[0]][1] != -1) {
                    int length = ans[edge[0]][1] + 1;
                    if (ans[edge[1]][0] == -1) {
                        ans[edge[1]][0] = length;
                    } else {
                        ans[edge[1]][0] = Math.min(ans[edge[1]][0],length);
                    }
                    nextStartPointSet.add(edge[1]);
                    redAdd = true;
                }
            }
            List<int[]> nextRedEdgeList = new ArrayList<>();
            for (int[] edge : redEdgeList) {
                if (!(startPointSet.contains(edge[0]) && ans[edge[0]][1] != -1)) {
                    nextRedEdgeList.add(edge);
                }
            }
            if (redEdgeList.size() == nextRedEdgeList.size()) {
                nextStartPointSet.addAll(startPointSet);
            }
            redEdgeList = nextRedEdgeList;

            boolean blueAdd = false;
            for (int[] edge : blueEdgeList) {
                if (startPointSet.contains(edge[0]) && ans[edge[0]][0] != -1) {
                    int length = ans[edge[0]][0] + 1;
                    if (ans[edge[1]][1] == -1) {
                        ans[edge[1]][1] = length;
                    } else {
                        ans[edge[1]][1] = Math.min(ans[edge[1]][1],length);
                    }
                    nextStartPointSet.add(edge[1]);
                    blueAdd = true;
                }
            }
            List<int[]> nextBlueEdgeList = new ArrayList<>();
            for (int[] edge : blueEdgeList) {
                if (!(startPointSet.contains(edge[0]) && ans[edge[0]][0] != -1)) {
                    nextBlueEdgeList.add(edge);
                }
            }
            if (blueEdgeList.size() == nextBlueEdgeList.size()) {
                nextStartPointSet.addAll(startPointSet);
            }
            blueEdgeList = nextBlueEdgeList;
            go = redAdd || blueAdd;
            startPointSet = nextStartPointSet;
        }
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            int red = ans[i][0];
            int blue = ans[i][1];
            if (red == -1 && blue == -1) {
                res[i] = -1;
            } else if (red == -1) {
                res[i] = blue;
            } else if (blue == -1) {
                res[i] = red;
            } else {
                res[i] = Math.min(red, blue);
            }
        }
        return res;
    }

    // 优化后，有提升，但不多，从 5% -> 7%
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] ans = new int[n][2];
        for (int[] an : ans) {
            Arrays.fill(an,-1);
        }
        ans[0][0] = 0;
        ans[0][1] = 0;
        Set<Integer> startPointSet = new HashSet<>();
        startPointSet.add(0);
        boolean go = true;
        while (go) {
            Set<Integer> nextStartPointSet = new HashSet<>();
            boolean redAdd = false;
            for (int[] edge : redEdges) {
                if (startPointSet.contains(edge[0]) && ans[edge[0]][1] != -1) {
                    int length = ans[edge[0]][1] + 1;
                    if (ans[edge[1]][0] == -1 || length < ans[edge[1]][0]) {
                        ans[edge[1]][0] = length;
                        redAdd = true;
                    }
                    nextStartPointSet.add(edge[1]);
                }
            }
            boolean blueAdd = false;
            for (int[] edge : blueEdges) {
                if (startPointSet.contains(edge[0]) && ans[edge[0]][0] != -1) {
                    int length = ans[edge[0]][0] + 1;
                    if (ans[edge[1]][1] == -1 || length < ans[edge[1]][1]) {
                        ans[edge[1]][1] = length;
                        blueAdd = true;
                    }
                    nextStartPointSet.add(edge[1]);
                }
            }
            go = redAdd || blueAdd;
            startPointSet = nextStartPointSet;
        }
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            int red = ans[i][0];
            int blue = ans[i][1];
            if (red == -1 && blue == -1) {
                res[i] = -1;
            } else if (red == -1) {
                res[i] = blue;
            } else if (blue == -1) {
                res[i] = red;
            } else {
                res[i] = Math.min(red, blue);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestAlternatingPaths shortestAlternatingPaths = new ShortestAlternatingPaths();
        System.out.println(Arrays.toString(shortestAlternatingPaths
                .shortestAlternatingPaths(5,
                        new int[][]{{3, 2}, {4, 1}, {1, 4}, {2,4}},
                        new int[][]{{2,3},{0,4},{4,3},{4,4},{4,0},{1,0}})));
        System.out.println(Arrays.toString(shortestAlternatingPaths
                .shortestAlternatingPaths(5,
                        new int[][]{{0, 1}, {1, 2}, {2, 3}, {3,4}},
                        new int[][]{{1,2},{2,3},{3,1}})));
        System.out.println(Arrays.toString(shortestAlternatingPaths
                .shortestAlternatingPaths(3,
                        new int[][]{{0, 1}, {0, 2}},
                        new int[][]{{1,0}})));
        System.out.println(Arrays.toString(shortestAlternatingPaths
                .shortestAlternatingPaths(3,
                        new int[][]{{0, 1}},
                        new int[][]{{1,2}})));
        System.out.println(Arrays.toString(shortestAlternatingPaths
                .shortestAlternatingPaths(3,
                        new int[][]{{1, 0}},
                        new int[][]{{2,1}})));
        System.out.println(Arrays.toString(shortestAlternatingPaths
                .shortestAlternatingPaths(3,
                        new int[][]{{0, 1}},
                        new int[][]{{2,1}})));
        System.out.println(Arrays.toString(shortestAlternatingPaths
                .shortestAlternatingPaths(3,
                new int[][]{{0, 1}, {1, 2}},
                new int[][]{})));
    }

}
