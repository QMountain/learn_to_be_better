package algorithm.leetcode.medium.f;

public class FindChampion {

    public int findChampion(int n, int[][] edges) {
        int[] teams = new int[n];
        for (int[] edge : edges) {
            teams[edge[1]] = 1;
        }
        boolean single = true;
        int team = -1;
        for (int i = 0; i < n; i++) {
            if (teams[i] == 0) {
                if (single) {
                    team = i;
                    single = false;
                } else {
                    return -1;
                }
            }
        }
        return team;
    }

    public static void main(String[] args) {
        FindChampion findChampion = new FindChampion();
        System.out.println(-1 == findChampion.findChampion(4, new int[][]{{0,2},{1,3},{1,2}}));
        System.out.println(0 == findChampion.findChampion(3, new int[][]{{0,1},{1,2}}));
    }
}
