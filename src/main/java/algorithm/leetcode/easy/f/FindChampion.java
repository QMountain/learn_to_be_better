package algorithm.leetcode.easy.f;

public class FindChampion {

    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int team = 0; team < n; team++) {
            boolean someOneBetter = false;
            for (int[] ints : grid) {
                if (ints[team] == 1) {
                    someOneBetter = true;
                    break;
                }
            }
            if (!someOneBetter) {
                return team;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindChampion findChampion = new FindChampion();
        System.out.println(1 == findChampion.findChampion(
                new int[][]{{0,0,1},{1,0,1},{0,0,0}}));
        System.out.println(0 == findChampion.findChampion(new int[][]{{0,1},{0,0}}));
    }
}
