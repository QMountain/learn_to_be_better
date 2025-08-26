package algorithm.leetcode.easy.a;

public class AreaOfMaxDiagonal {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = 0;
        int ans = 0;
        for (int[] dimension : dimensions) {
            int curr = dimension[0] * dimension[0] + (dimension[1] * dimension[1]);
            if (curr > max) {
                max = curr;
                ans = dimension[0] * dimension[1];
            } else if (curr == max) {
                ans = Math.max(ans, dimension[0] * dimension[1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AreaOfMaxDiagonal areaOfMaxDiagonal = new AreaOfMaxDiagonal();
        System.out.println(areaOfMaxDiagonal.areaOfMaxDiagonal(new int[][]{{6,5},{8,6},{2,10},{8,1},{9,2},{3,5},{3,5}}));
    }
}
