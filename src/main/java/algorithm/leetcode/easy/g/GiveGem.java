package algorithm.leetcode.easy.g;

public class GiveGem {

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int cut = gem[operation[0]] / 2;
            gem[operation[0]] -= cut;
            gem[operation[1]] += cut;
        }
        int max = gem[0];
        int min = gem[0];
        for (int i : gem) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }

    public static void main(String[] args) {
        GiveGem giveGem = new GiveGem();
        System.out.println(giveGem.giveGem(new int[]{100,0,50,100}, new int[][]{{0, 2}, {0, 1}, {3, 0}, {3, 0}}));
    }
}
